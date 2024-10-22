package benchmarks;

import benchmarks.avro.Person;
import benchmarks.proto.PersonProtoClass;
import com.google.common.collect.Lists;
import com.google.common.primitives.Bytes;
import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.serializer.Specification;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BenchmarkTest {
    private final ProtobufSerializer protobufSerializer = new ProtobufSerializer();
    private final CustomSerializer customSerializer = new CustomSerializer();
    private final AvroSerializer avroSerializer = new AvroSerializer();
    private final PersonProtoClass.Person personProto = createProtobufObjectPerson();
    private final CustomPerson personCustom = createCustomObjectPerson();
    private final Person personAvro = createAvroObjectPerson();
    private final Map<String, List<String>> protoResultMap = new ConcurrentHashMap<>();
    private final Map<String, List<String>> avroResultMap = new ConcurrentHashMap<>();
    private final Map<String, List<String>> customResultMap = new ConcurrentHashMap<>();

    public static class CustomPerson {
        public String name = "Kseniia";
        public String surname = "Samarina";
        public Integer id = 123;
        public String email = "kseniia.samarina@gmail.com";
        public Boolean sex = false;
        public Long phoneNumber = 79531512129L;
    }


    public BenchmarkTest() throws IOException {
        serializeAndDeserializeProtobuf(personProto);
        serializeAndDeserializeAvro(personAvro);
    }

    @AfterAll
    public void done() {
        System.out.println(protoResultMap);
        for (Map.Entry<String, List<String>> entries : protoResultMap.entrySet()) {
            final double average = entries
                    .getValue()
                    .stream()
                    .map(i -> Integer.valueOf(StringUtils.trim(i).replaceAll("protobuf :", "").replaceAll("ms", "").trim()))
                    .toList()
                    .stream()
                    .mapToDouble(a -> a)
                    .average()
                    .getAsDouble();
            System.out.println(entries.getKey() + " -> proto average : " + average);
        }
        System.out.println(avroResultMap);
        for (Map.Entry<String, List<String>> entries : avroResultMap.entrySet()) {
            final double average = entries
                    .getValue()
                    .stream()
                    .map(i -> Integer.valueOf(StringUtils.trim(i).replaceAll("avro :", "").replaceAll("ms", "").trim()))
                    .toList()
                    .stream()
                    .mapToDouble(a -> a)
                    .average()
                    .getAsDouble();
            System.out.println(entries.getKey() + " -> avro average : " + average);
        }
        System.out.println(customResultMap);
        for (Map.Entry<String, List<String>> entries : customResultMap.entrySet()) {
            final double average = entries
                    .getValue()
                    .stream()
                    .map(i -> Integer.valueOf(StringUtils.trim(i).replaceAll("custom :", "").replaceAll("ms", "").trim()))
                    .toList()
                    .stream()
                    .mapToDouble(a -> a)
                    .average()
                    .getAsDouble();
            System.out.println(entries.getKey() + " -> custom average : " + average);
        }
    }

    @Execution(ExecutionMode.CONCURRENT)
    @RepeatedTest(5)
    public void executeProtoSerde() {
//        IntStream.of(1_000_000, 5_000_000, 10_000_000).forEach(iteration -> {
        IntStream.of(1_000).forEach(iteration -> {
            final String result = testPerformance(() -> {
                try {
                    serializeAndDeserializeProtobuf(personProto);
                } catch (InvalidProtocolBufferException e) {
                    throw new RuntimeException(e);
                }
            }, "protobuf", iteration);
            final List<String> outputs = protoResultMap.putIfAbsent("\nIteration : " + iteration, Lists.newArrayList("\n" + result));
            if (outputs == null) {
                return;
            }
            outputs.add("\n" + result);
            protoResultMap.put("\nIteration : " + iteration, outputs);
        });
    }

    @Execution(ExecutionMode.CONCURRENT)
    @RepeatedTest(5)
    public void executeAvroSerde() {
//        IntStream.of(1_000_000, 5_000_000, 10_000_000).forEach(iteration -> {
        IntStream.of(1_000).forEach(iteration -> {
            final String result = testPerformance(() -> {
                try {
                    serializeAndDeserializeAvro(personAvro);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, "avro", iteration);
            final List<String> outputs = avroResultMap.putIfAbsent("\nIteration : " + iteration, Lists.newArrayList("\n" + result));
            if (outputs == null) {
                return;
            }
            outputs.add("\n" + result);
            avroResultMap.put("\nIteration : " + iteration, outputs);
        });
    }

    @Execution(ExecutionMode.CONCURRENT)
    @RepeatedTest(5)
    public void executeCustomSerde() {
//        IntStream.of(1_000_000, 5_000_000, 10_000_000).forEach(iteration -> {
        IntStream.of(1_000).forEach(iteration -> {
            final String result = testPerformance(() -> {
                try {
                    serializeAndDeserializeCustom(personCustom);
                } catch (InstantiationException | IOException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }, "custom", iteration);
            final List<String> outputs = customResultMap.putIfAbsent("\nIteration : " + iteration, Lists.newArrayList("\n" + result));
            if (outputs == null) {
                return;
            }
            outputs.add("\n" + result);
            customResultMap.put("\nIteration : " + iteration, outputs);
        });
    }

    @RepeatedTest(1)
    public void executeMemoryTest() throws IOException, IllegalAccessException {
        System.out.println(System.out.format("Memory usage Custom serializer: %s bytes\n", customSerializer.serialize(createCustomObjectPerson()).length));
        System.out.println(System.out.format("Memory usage Protobuf serializer: %s bytes\n", protobufSerializer.serialize(createProtobufObjectPerson()).length));
        System.out.println(System.out.format("Memory usage Avro serializer: %s bytes\n", avroSerializer.serialize(createAvroObjectPerson()).length));
    }

    public void serializeAndDeserializeProtobuf(PersonProtoClass.Person protobufObjectPerson) throws InvalidProtocolBufferException {
        var bytes = protobufSerializer.serialize(protobufObjectPerson);
        protobufSerializer.deserialize(bytes);
    }

    public void serializeAndDeserializeCustom(CustomPerson customObjectPerson) throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        var bytes = customSerializer.serialize(customObjectPerson);
        customSerializer.deserialize(bytes);
    }

    public void serializeAndDeserializeAvro(Person avroObjectPerson) throws IOException {
        var bytes = avroSerializer.serialize(avroObjectPerson);
        avroSerializer.deserialize(bytes);
    }

    private PersonProtoClass.Person createProtobufObjectPerson() {
        char[] chars = new char[1_000_000];
        Arrays.fill(chars, 'a');
        return PersonProtoClass.Person.newBuilder()
                .addNameSurname("Kseniia")
                .addNameSurname("Samarina")
                .setId(123)
                .setEmail(new String(chars))
                .setSex(false)
                .setPhoneNumber(79531512129L)
                .build();
    }

    private Person createAvroObjectPerson() {
        char[] chars = new char[1_000_000];
        Arrays.fill(chars, 'a');
        return Person.newBuilder()
                .setName("Kseniia")
                .setSurname("Samarina")
                .setId(123)
                .setEmail(new String(chars))
                .setSex(false)
                .setPhoneNumber(79531512129L)
                .build();
    }

    private CustomPerson createCustomObjectPerson() {
        CustomPerson person = new CustomPerson();
        char[] chars = new char[1_000_000];
        Arrays.fill(chars, 'a');
        person.email = new String(chars);
        return person;
    }

    private String testPerformance(Runnable runnable, String method, int iterations) {
        long start = System.currentTimeMillis();
        IntStream.range(0, iterations).forEach(i -> runnable.run());
        long finish = System.currentTimeMillis();
        return method + " : " + (finish - start) + " ms";
    }

    private static class ProtobufSerializer {

        public byte[] serialize(PersonProtoClass.Person protobufObjectPerson) {
            return protobufObjectPerson.toByteArray();
        }

        public void deserialize(byte[] bytes) throws InvalidProtocolBufferException {
            PersonProtoClass.Person.parseFrom(bytes);
        }
    }

    private static class AvroSerializer {

        public byte[] serialize(Person avroObjectPerson) throws IOException {
            DatumWriter<Person> userDatumWriter = new SpecificDatumWriter<>(Person.class);

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            Encoder encoder = EncoderFactory.get().binaryEncoder(output, null);

            userDatumWriter.write(avroObjectPerson, encoder);
            encoder.flush();
            return output.toByteArray();
        }

        public void deserialize(byte[] bytes) {
            DatumReader<Person> personDatumReader = new SpecificDatumReader<>(Person.class);

            ByteArrayInputStream output = new ByteArrayInputStream(bytes);
            Decoder decoder = DecoderFactory.get().binaryDecoder(output, null);

            try {
                personDatumReader.read(null, decoder);
            } catch (IOException ignored) {
            }
        }
    }

    private static class CustomSerializer {
        Specification spec = new Specification();

        public byte[] serialize(CustomPerson customObjectPerson) throws IllegalAccessException {
            return Bytes.toArray(spec.serialize(customObjectPerson));
        }

        public void deserialize(byte[] bytes) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            spec.deserialize(Bytes.asList(bytes), CustomPerson.class);
        }
    }

}