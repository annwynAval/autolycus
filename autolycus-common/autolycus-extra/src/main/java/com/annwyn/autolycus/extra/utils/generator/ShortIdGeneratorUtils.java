package com.annwyn.autolycus.extra.utils.generator;

public class ShortIdGeneratorUtils extends UUIdGeneratorUtils implements IdGeneratorUtils {

    private static final char[] chars = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
            'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    @Override
    public String generator() {
        String uuid = super.generator();
        StringBuilder stringBuilder = new StringBuilder();
        for(int index = 0; index < 8; index++) {
            stringBuilder.append(chars[Integer.parseInt(uuid.substring(index * 4, index * 4 + 4), 16) % 0x3E]);
        }
        return stringBuilder.toString();
    }
}
