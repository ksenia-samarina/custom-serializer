package org.serializer.model;

import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

import java.util.Optional;

public class StringItem implements Item<String> {
    private static final Type type = Type.STRING;
    private static final Type shortType = Type.SHORT_STRING;
    private String value;

    private static boolean containsOnlySixBitChar(String str) {
        return str.matches("[a-zA-Z0-9._]+");
    }

    private static Optional<Integer> charToInt(char c) {
        if (c >= 'a' && c <= 'z') {
            return Optional.of(c - 'a');
        } else if (c >= 'A' && c <= 'Z') {
            return Optional.of(26 + (c - 'A'));
        } else if (c >= '0' && c <= '9') {
            return Optional.of(52 + (c - '0'));
        } else if (c == '.') {
            return Optional.of(62);
        } else if (c == '_') {
            return Optional.of(63);
        }
        return Optional.empty();
    }

    private static Optional<Character> intToChar(int n) {
        if (n == 63) {
            return Optional.of('_');
        } else if (n == 62) {
            return Optional.of('.');
        } else if ((n - 52 + '0') >= '0' && (n - 52 + '0') <= '9') {
            return Optional.of((char) (n - 52 + '0'));
        } else if ((n - 26 + 'A') >= 'A' && (n - 26 + 'A') <= 'Z') {
            return Optional.of((char) (n - 26 + 'A'));
        } else if ((n + 'a') >= 'a' && (n + 'a') <= 'z') {
            return Optional.of((char) (n + 'a'));
        }
        return Optional.empty();
    }

    public StringItem(String payload) {
        value = payload;
    }

    public StringItem() {
    }

    @Override
    public void encode(OutputStream out) {
        if (containsOnlySixBitChar(value)) {
            int bitsPerChar = 6;
            char[] chars = value.toCharArray();
            int totalBits = chars.length * bitsPerChar + 1;
            int byteLength = (totalBits + 7) / 8;
            byte[] bytes = new byte[byteLength];
            int currentBit = 1;
            for (char c : chars) {
                int val = charToInt(c).orElseThrow();
                for (int i = bitsPerChar - 1; i >= 0; i--) {
                    if ((val & (1 << i)) != 0) {
                        int bytePos = currentBit / 8;
                        int bitPos = currentBit % 8;
                        bytes[bytePos] |= (byte) (1 << (7 - bitPos));
                    }
                    currentBit++;
                }
            }
            boolean stripLastChar = bytes.length * 8 >= totalBits + bitsPerChar;
            if (stripLastChar) {
                bytes[0] = (byte) (bytes[0] | 0x80);
            }
            out.writeBytes(shortType, bytes);
        } else {
            out.writeBytes(type, value.getBytes());
        }
    }

    @Override
    public String decodeShort(InputStream in) {
        byte[] bytes = in.readBytes();
        StringBuilder decoded = new StringBuilder();
        int bitIndex = 1;
        boolean stripLastChar = (bytes[0] & 0x80) != 0;
        int bitMask = 0b111111;
        int numBits = bytes.length * 8;
        while (bitIndex + 6 <= numBits && !(stripLastChar && (bitIndex + 2 * 6 > numBits))) {
            int byteIndex = bitIndex / 8;
            int intraByteIndex = bitIndex % 8;

            int charValue;
            if (intraByteIndex > 2) {
                charValue =
                        ((bytes[byteIndex] & 0xFF) << 8)
                                | (byteIndex + 1 < bytes.length ? (bytes[byteIndex + 1] & 0xFF) : 0);
                charValue = ((byte) ((charValue >> (10 - intraByteIndex)) & bitMask));
            } else {
                charValue = bytes[byteIndex] >> (2 - intraByteIndex) & bitMask;
            }
            bitIndex += 6;
            decoded.append(intToChar(charValue).orElseThrow());
        }
        return decoded.toString();
    }

    @Override
    public String decode(InputStream in) {
        return new String(in.readBytes());
    }

    public void setValue(String payload) {
        value = payload;
    }

    public String getValue() {
        return value;
    }
}
