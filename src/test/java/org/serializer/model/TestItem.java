package org.serializer.model;

import org.junit.Test;
import org.serializer.datastream.DataInput;
import org.serializer.datastream.DataOutput;
import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public final class TestItem {
    @Test
    public void testFalseBooleanItem() {
        OutputStream out = new DataOutput();

        Item<Boolean> item = new BooleanItem();
        item.setValue(false);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(false, item.decode(in));
    }

    @Test
    public void testTrueBooleanItem() {
        OutputStream out = new DataOutput();

        Item<Boolean> item = new BooleanItem();
        item.setValue(true);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(true, item.decode(in));
    }

    @Test
    public void testPositiveIntegerItem() {
        OutputStream out = new DataOutput();

        Item<Integer> item = new IntegerItem();
        item.setValue(42);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(42L, ((Number) item.decode(in)).longValue());
    }

    @Test
    public void testNegativeIntegerItem() {
        OutputStream out = new DataOutput();

        IntegerItem item = new IntegerItem(-42);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(-42L, (long) item.decode(in));
    }

    @Test
    public void testZeroIntegerItem() {
        OutputStream out = new DataOutput();

        Item<Integer> item = new IntegerItem(0);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(0L, ((Number) item.decode(in)).longValue());
    }

    @Test
    public void testPositiveLongItem() {
        OutputStream out = new DataOutput();

        Item<Long> item = new LongItem();
        item.setValue(42L);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(42L, (long) item.decode(in));
    }

    @Test
    public void testNegativeLongItem() {
        OutputStream out = new DataOutput();

        Item<Long> item = new LongItem(-42L);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(-42L, (long) item.decode(in));
    }

    @Test
    public void testZeroLongItem() {
        OutputStream out = new DataOutput();

        Item<Long> item = new LongItem(0L);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(0L, (long) item.decode(in));
    }

    @Test
    public void testSixBitStringItem() {
        OutputStream out = new DataOutput();

        Item<String> item = new StringItem("abc");
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals("abc", item.decodeShort(in));
    }

    @Test
    public void testStringItem() {
        OutputStream out = new DataOutput();

        Item<String> item = new StringItem("abc@gmail.com");
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals("abc@gmail.com", item.decode(in));
    }

    @Test
    public void testSixBitLongStringItem() {
        OutputStream out = new DataOutput();

        Item<String> item = new StringItem("alpha_beta_gamma");
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals("alpha_beta_gamma", item.decodeShort(in));
    }

    @Test
    public void testListItem() {
        OutputStream out = new DataOutput();
        List<Item<?>> list = Arrays.asList(
                new BooleanItem(true),
                new IntegerItem(42),
                new LongItem(42L),
                new StringItem("abc"),
                new ArrayItem(
                        Arrays.asList(
                                new BooleanItem(true),
                                new IntegerItem(42),
                                new LongItem(42L),
                                new StringItem("abc")
                        )
                )
        );

        Item<List<Item<?>>> item = new ArrayItem(list);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(Arrays.asList(true, 42, 42L, "abc", Arrays.asList(true, 42, 42L, "abc")), item.decode(in));
    }

    @Test
    public void testMapItem() {
        OutputStream out = new DataOutput();
        Map<Item<?>, Item<?>> map = new HashMap<>() {{
            put(new StringItem("a"), new BooleanItem(true));
            put(new StringItem("b"), new IntegerItem(42));
            put(new StringItem("c"), new LongItem(42L));
            put(new StringItem("d"), new StringItem("abc"));
            put(new StringItem("e"), new ArrayItem(
                    Arrays.asList(
                            new BooleanItem(true),
                            new IntegerItem(42),
                            new LongItem(42L),
                            new StringItem("abc"),
                            new MapItem(new HashMap<>(){{put(new StringItem("a"), new BooleanItem(true));}})
                    )
            ));
            put(new StringItem("f"), new MapItem(
                    new HashMap<>(){{
                        put(new StringItem("a"), new BooleanItem(true));
                    }}
            ));
        }};

        Item<Map<Item<?>, Item<?>>> item = new MapItem(map);
        item.encode(out);

        InputStream in = new DataInput(out.toByteList());
        in.read();

        assertEquals(
                new HashMap<String, Object>() {{
                    put("a", true);
                    put("b", 42);
                    put("c", 42L);
                    put("d", "abc");
                    put("e", Arrays.asList(true, 42, 42L, "abc", new HashMap<>(){{put("a", true);}}));
                    put("f", new HashMap<>(){{put("a", true);}});
                }},
                item.decode(in)
        );
    }
}
