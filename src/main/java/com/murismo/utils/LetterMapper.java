package com.murismo.utils;

import java.util.*;


public class LetterMapper {
    private final Map<String, Byte> finder = new HashMap<>();
    private final Map<Byte, String> reverseFinder = new HashMap<>();

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
        this.reverseFinder.put((byte) 0, " ");
        this.reverseFinder.put((byte) 1, "!");
        this.reverseFinder.put((byte) 2, "\"");
        this.reverseFinder.put((byte) 3, "#");
        this.reverseFinder.put((byte) 4, "$");
        this.reverseFinder.put((byte) 5, "%");
        this.reverseFinder.put((byte) 6, "&");
        this.reverseFinder.put((byte) 8, "(");
        this.reverseFinder.put((byte) 9, ")");
        this.reverseFinder.put((byte) 10, "*");
        this.reverseFinder.put((byte) 11, "+");
        this.reverseFinder.put((byte) 12, ",");
        this.reverseFinder.put((byte) 13, "-");
        this.reverseFinder.put((byte) 14, ".");
        this.reverseFinder.put((byte) 16, "0");
        this.reverseFinder.put((byte) 17, "1");
        this.reverseFinder.put((byte) 18, "2");
        this.reverseFinder.put((byte) 19, "3");
        this.reverseFinder.put((byte) 20, "4");
        this.reverseFinder.put((byte) 21, "5");
        this.reverseFinder.put((byte) 22, "6");
        this.reverseFinder.put((byte) 23, "7");
        this.reverseFinder.put((byte) 24, "8");
        this.reverseFinder.put((byte) 25, "9");
        this.reverseFinder.put((byte) 26, ":");
        this.reverseFinder.put((byte) 27, ";");
        this.reverseFinder.put((byte) 28, "<");
        this.reverseFinder.put((byte) 29, "=");
        this.reverseFinder.put((byte) 30, ">");
        this.reverseFinder.put((byte) 31, "?");
        this.reverseFinder.put((byte) 32, "@");
        this.reverseFinder.put((byte) 33, "A");
        this.reverseFinder.put((byte) 34, "B");
        this.reverseFinder.put((byte) 35, "C");
        this.reverseFinder.put((byte) 36, "D");
        this.reverseFinder.put((byte) 37, "E");
        this.reverseFinder.put((byte) 38, "F");
        this.reverseFinder.put((byte) 39, "G");
        this.reverseFinder.put((byte) 40, "H");
        this.reverseFinder.put((byte) 41, "I");
        this.reverseFinder.put((byte) 42, "J");
        this.reverseFinder.put((byte) 43, "K");
        this.reverseFinder.put((byte) 44, "L");
        this.reverseFinder.put((byte) 45, "M");
        this.reverseFinder.put((byte) 46, "N");
        this.reverseFinder.put((byte) 47, "O");
        this.reverseFinder.put((byte) 48, "P");
        this.reverseFinder.put((byte) 49, "Q");
        this.reverseFinder.put((byte) 50, "R");
        this.reverseFinder.put((byte) 51, "S");
        this.reverseFinder.put((byte) 52, "T");
        this.reverseFinder.put((byte) 53, "U");
        this.reverseFinder.put((byte) 54, "V");
        this.reverseFinder.put((byte) 55, "W");
        this.reverseFinder.put((byte) 56, "X");
        this.reverseFinder.put((byte) 57, "Y");
        this.reverseFinder.put((byte) 58, "Z");
        this.reverseFinder.put((byte) 59, "[");
        this.reverseFinder.put((byte) 61, "]");
        this.reverseFinder.put((byte) 62, "^");
        this.reverseFinder.put((byte) 63, "_");
        this.reverseFinder.put((byte) 65, "a");
        this.reverseFinder.put((byte) 66, "b");
        this.reverseFinder.put((byte) 67, "c");
        this.reverseFinder.put((byte) 68, "d");
        this.reverseFinder.put((byte) 69, "e");
        this.reverseFinder.put((byte) 70, "f");
        this.reverseFinder.put((byte) 71, "g");
        this.reverseFinder.put((byte) 72, "h");
        this.reverseFinder.put((byte) 73, "i");
        this.reverseFinder.put((byte) 74, "j");
        this.reverseFinder.put((byte) 75, "k");
        this.reverseFinder.put((byte) 76, "l");
        this.reverseFinder.put((byte) 77, "m");
        this.reverseFinder.put((byte) 78, "n");
        this.reverseFinder.put((byte) 79, "o");
        this.reverseFinder.put((byte) 80, "p");
        this.reverseFinder.put((byte) 81, "q");
        this.reverseFinder.put((byte) 82, "r");
        this.reverseFinder.put((byte) 83, "s");
        this.reverseFinder.put((byte) 84, "t");
        this.reverseFinder.put((byte) 85, "u");
        this.reverseFinder.put((byte) 86, "v");
        this.reverseFinder.put((byte) 87, "w");
        this.reverseFinder.put((byte) 88, "x");
        this.reverseFinder.put((byte) 89, "y");
        this.reverseFinder.put((byte) 90, "z");
    }

    public byte[] convertStringToFF7(String str) {

        if(str.length() > 9) {
            throw new RuntimeException("String too long");
        }
        
        byte[] packed = new byte[10];
        Arrays.fill(packed, (byte) 255);

        String[] chars = str.split("");

        for (int i = 0; i < chars.length; i++) {
            packed[i] = finder.get(chars[i]);
        }
        return packed;
    }

    public String convertFF7ToString(byte[] ff7Text) {

        StringBuilder normieText = new StringBuilder();

        for(byte b : ff7Text) {

            if(b == -1) {
                continue;
            }

            normieText.append(this.reverseFinder.get(b));
        }

        return normieText.toString();


    }
}
