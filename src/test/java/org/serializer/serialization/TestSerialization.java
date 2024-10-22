package org.serializer.serialization;

import org.junit.Test;
import org.serializer.builder.ArrayBuilder;
import org.serializer.builder.MapBuilder;
import org.serializer.builder.SerializerBuilder;
import org.serializer.datastream.DataInput;
import org.serializer.datastream.DataOutput;
import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestSerialization {
    @Test
    public void testSerializerBuilder() {
        OutputStream out = new DataOutput();
        new SerializerEncoder(out).encode(
                new SerializerBuilder()
                        .add(42L)
                        .add(false)
                        .add(42)
                        .add("abc")
                        .add("alpha_beta_gamma")
                        .build()
        );
        List<Byte> bytes = out.toByteList();
        InputStream in = new DataInput(bytes);
        List<?> items = new SerializerDecoder(in).decode();

        assertEquals(Arrays.asList(42L, false, 42, "abc", "alpha_beta_gamma"), items);
    }

    @Test
    public void testArrayBuilder() {
        OutputStream out = new DataOutput();
        new SerializerEncoder(out).encode(
                new ArrayBuilder(new SerializerBuilder())
                        .add(true)
                        .add(42)
                        .add(42L)
                        .add("abc")
                        .end()
                        .build()
        );
        List<Byte> bytes = out.toByteList();
        InputStream in = new DataInput(bytes);
        List<?> items = new SerializerDecoder(in).decode();

        assertEquals(Arrays.asList(true, 42, 42L, "abc"), items.getFirst());
    }

    @Test
    public void testNestedArrayBuilder() {
        OutputStream out = new DataOutput();
        new SerializerEncoder(out).encode(
                new SerializerBuilder()
                        .add(42L)
                        .add(false)
                        .addArray()
                            .add(56L)
                            .add("abcd")
                            .add(false)
                            .end()
                        .add(42)
                        .add("abc")
                        .add("alpha_beta_gamma")
                        .build()
        );
        List<Byte> bytes = out.toByteList();
        InputStream in = new DataInput(bytes);
        List<?> items = new SerializerDecoder(in).decode();

        assertEquals(
                Arrays.asList(42L, false, Arrays.asList(56L, "abcd", false), 42, "abc", "alpha_beta_gamma"),
                items
        );
    }

    @Test
    public void testNestedArraysBuilder() {
        OutputStream out = new DataOutput();
        new SerializerEncoder(out).encode(
                new SerializerBuilder()
                        .add(42L)
                        .add(false)
                        .addArray()
                            .add(56L)
                            .add("abcd")
                            .add(false)
                            .end()
                        .addArray()
                            .add(56L)
                            .add("abcd")
                            .add(false)
                            .end()
                        .add(42)
                        .add("abc")
                        .add("alpha_beta_gamma")
                        .build()
        );
        List<Byte> bytes = out.toByteList();
        InputStream in = new DataInput(bytes);
        List<?> items = new SerializerDecoder(in).decode();

        assertEquals(
                Arrays.asList(42L, false, Arrays.asList(56L, "abcd", false), Arrays.asList(56L, "abcd", false), 42, "abc", "alpha_beta_gamma"),
                items
        );
    }

    @Test
    public void testMapBuilder() {
        OutputStream out = new DataOutput();
        new SerializerEncoder(out).encode(
                new MapBuilder(new SerializerBuilder())
                        .addEntry("a")
                        .add(true)
                        .endEntry()
                        .addEntry("b")
                        .add(42)
                        .endEntry()
                        .addEntry("c")
                        .add(42L)
                        .endEntry()
                        .addEntry("d")
                        .add("abc")
                        .endEntry()
                        .addEntry("e")
                            .addArray()
                                .add(56L)
                                .add("abcd")
                                .add(false)
                                .end()
                        .endEntry()
                        .addEntry("f")
                            .addMap()
                                .addEntry("a")
                                .add(false)
                                .endEntry()
                                .end()
                        .endEntry()
                        .end()
                        .build()
        );
        List<Byte> bytes = out.toByteList();
        InputStream in = new DataInput(bytes);
        List<?> items = new SerializerDecoder(in).decode();

        assertEquals(
                new HashMap<>(){{
                    put("a", true);
                    put("b", 42);
                    put("c", 42L);
                    put("d", "abc");
                    put("e", Arrays.asList(56L, "abcd", false));
                    put("f", new HashMap<>(){{put("a", false);}});
                }},
                items.getFirst()
        );
    }
}