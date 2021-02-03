package com.annwyn.autolycus.extra.model;

/**
 * 分隔符
 */
public enum Separator {

    MIDDLE_LINE("-"),

    UNDER_LINE("_"),

    COMMA(",");

    private final String text;

    Separator(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
