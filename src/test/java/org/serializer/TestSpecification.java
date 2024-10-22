package org.serializer;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestSpecification {
    static final class TestCase1 {
        public int field1 = 42;
        public long field2 = 42L;
        public boolean field3 = true;
        public String field4 = "abcd";
        public List<Integer> field5 = Arrays.asList(1, 2, 3);
        public Map<String, Integer> field6 = new HashMap<>() {{
            put("a", 42);
            put("b", 43);
            put("c", 44);
        }};
    }

    @Test
    public void testClassSerialization() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        TestCase1 obj = new TestCase1();
        Specification spec = new Specification();

        List<Byte> bytes = spec.serialize(obj);
        TestCase1 deserObj = spec.deserialize(bytes, TestCase1.class);

        assertEquals(obj.field1, deserObj.field1);
        assertEquals(obj.field2, deserObj.field2);
        assertEquals(obj.field3, deserObj.field3);
        assertEquals(obj.field4, deserObj.field4);
        assertEquals(obj.field5, deserObj.field5);
        assertEquals(obj.field6, deserObj.field6);
    }

    static final class CustomPerson {
        CustomPerson(){}
        CustomPerson(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
        public String name = "Kseniia";
        public String surname = "Samarina";
        public Integer id = 123;
        public String email = "kseniia.samarina_gmail.com";
        public Boolean sex = false;
        public Long phoneNumber = 79531512129L;
    }

    @Test
    public void testPersonClassSerialization() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        CustomPerson obj = new CustomPerson("a", "b");
        Specification spec = new Specification();

        List<Byte> bytes = spec.serialize(obj);

        CustomPerson deserObj = spec.deserialize(bytes, CustomPerson.class);

        assertEquals(obj.name, deserObj.name);
        assertEquals(obj.surname, deserObj.surname);
        assertEquals(obj.id, deserObj.id);
        assertEquals(obj.email, deserObj.email);
        assertEquals(obj.sex, deserObj.sex);
        assertEquals(obj.phoneNumber, deserObj.phoneNumber);
    }
}
