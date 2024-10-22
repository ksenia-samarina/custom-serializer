package org.serializer;


import org.serializer.builder.Builder;
import org.serializer.builder.SerializerBuilder;
import org.serializer.datastream.DataInput;
import org.serializer.datastream.DataOutput;
import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;
import org.serializer.serialization.Encoder;
import org.serializer.serialization.SerializerDecoder;
import org.serializer.serialization.SerializerEncoder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class Specification {
    public List<Byte> serialize(Object object) throws IllegalAccessException {
        Builder builder = new SerializerBuilder();
        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            Object value = field.get(object);
            builder = addValue(builder, value);
        }

        OutputStream out = new DataOutput();
        Encoder encoder = new SerializerEncoder(out);
        encoder.encode(builder.build());
        return out.toByteList();
    }

    private Builder addValue(Builder builder, Object value) {
        if (value.getClass() == Integer.class) {
            builder = builder.add((Integer) value);
        } else if (value.getClass() == Long.class) {
            builder = builder.add((Long) value);
        } else if (value.getClass() == Boolean.class) {
            builder = builder.add((Boolean) value);
        } else if (value.getClass() == String.class) {
            builder = builder.add((String) value);
        } else if (value instanceof List) {
            builder = builder.addArray();
            for (Object obj : (List<?>) value) {
                addValue(builder, obj);
            }
            builder = builder.end();
        } else if (Map.class.isAssignableFrom(value.getClass())) {
            builder = builder.addMap();
            for (Map.Entry<?, ?> entry : ((Map<?, ?>) value).entrySet()) {
                String entryKey = (String) entry.getKey();
                builder = builder.addEntry(entryKey);

                Object entryValue = entry.getValue();
                addValue(builder, entryValue);

                builder = builder.endEntry();
            }
            builder = builder.end();
        }
        return builder;
    }

    public <T> T deserialize(List<Byte> bytes, Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStream in = new DataInput(bytes);
        List<?> items = new SerializerDecoder(in).decode();
        T obj = clazz.getDeclaredConstructor().newInstance();

        Field[] fields = clazz.getFields();
        for (int i = 0; i < items.size(); i++) {
            fields[i].set(obj, items.get(i));
        }
        return obj;
    }
}

