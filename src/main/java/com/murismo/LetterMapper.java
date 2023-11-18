package com.murismo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LetterMapper {
    private final Map<String, Byte> finder = new HashMap<>();

    public LetterMapper() {
        this.finder.put(" ", (byte) 0);
        this.finder.put("!", (byte) 1);
        this.finder.put("\"", (byte) 2);
        this.finder.put("#", (byte) 3);
        this.finder.put("$", (byte) 4);
        this.finder.put("%", (byte) 5);
        this.finder.put("&", (byte) 6);
        this.finder.put("(", (byte) 8);
        this.finder.put(")", (byte) 9);
        this.finder.put("*", (byte) 10);
        this.finder.put("+", (byte) 11);
        this.finder.put(",", (byte) 12);
        this.finder.put("-", (byte) 13);
        this.finder.put(".", (byte) 14);
        this.finder.put("0", (byte) 16);
        this.finder.put("1", (byte) 17);
        this.finder.put("2", (byte) 18);
        this.finder.put("3", (byte) 19);
        this.finder.put("4", (byte) 20);
        this.finder.put("5", (byte) 21);
        this.finder.put("6", (byte) 22);
        this.finder.put("7", (byte) 23);
        this.finder.put("8", (byte) 24);
        this.finder.put("9", (byte) 25);
        this.finder.put(":", (byte) 26);
        this.finder.put(";", (byte) 27);
        this.finder.put("<", (byte) 28);
        this.finder.put("=", (byte) 29);
        this.finder.put(">", (byte) 30);
        this.finder.put("?", (byte) 31);
        this.finder.put("@", (byte) 32);
        this.finder.put("A", (byte) 33);
        this.finder.put("B", (byte) 34);
        this.finder.put("C", (byte) 35);
        this.finder.put("D", (byte) 36);
        this.finder.put("E", (byte) 37);
        this.finder.put("F", (byte) 38);
        this.finder.put("G", (byte) 39);
        this.finder.put("H", (byte) 40);
        this.finder.put("I", (byte) 41);
        this.finder.put("J", (byte) 42);
        this.finder.put("K", (byte) 43);
        this.finder.put("L", (byte) 44);
        this.finder.put("M", (byte) 45);
        this.finder.put("N", (byte) 46);
        this.finder.put("O", (byte) 47);
        this.finder.put("P", (byte) 48);
        this.finder.put("Q", (byte) 49);
        this.finder.put("R", (byte) 50);
        this.finder.put("S", (byte) 51);
        this.finder.put("T", (byte) 52);
        this.finder.put("U", (byte) 53);
        this.finder.put("V", (byte) 54);
        this.finder.put("W", (byte) 55);
        this.finder.put("X", (byte) 56);
        this.finder.put("Y", (byte) 57);
        this.finder.put("Z", (byte) 58);
        this.finder.put("[", (byte) 59);
        this.finder.put("]", (byte) 61);
        this.finder.put("^", (byte) 62);
        this.finder.put("_", (byte) 63);
        this.finder.put("a", (byte) 65);
        this.finder.put("b", (byte) 66);
        this.finder.put("c", (byte) 67);
        this.finder.put("d", (byte) 68);
        this.finder.put("e", (byte) 69);
        this.finder.put("f", (byte) 70);
        this.finder.put("g", (byte) 71);
        this.finder.put("h", (byte) 72);
        this.finder.put("i", (byte) 73);
        this.finder.put("j", (byte) 74);
        this.finder.put("k", (byte) 75);
        this.finder.put("l", (byte) 76);
        this.finder.put("m", (byte) 77);
        this.finder.put("n", (byte) 78);
        this.finder.put("o", (byte) 79);
        this.finder.put("p", (byte) 80);
        this.finder.put("q", (byte) 81);
        this.finder.put("r", (byte) 82);
        this.finder.put("s", (byte) 83);
        this.finder.put("t", (byte) 84);
        this.finder.put("u", (byte) 85);
        this.finder.put("v", (byte) 86);
        this.finder.put("w", (byte) 87);
        this.finder.put("x", (byte) 88);
        this.finder.put("y", (byte) 89);
        this.finder.put("z", (byte) 90);
    }

    public byte[] convertStringToFF7(String str) {

        if(str.length() > 9) {
            throw new RuntimeException("String too long bebbe");
        }
        
        byte[] packed = new byte[10];
        Arrays.fill(packed, (byte) 255);

        String[] chars = str.split("");

        for (int i = 0; i < chars.length; i++) {
            packed[i] = finder.get(chars[i]);
        }
        return packed;
    }
}
