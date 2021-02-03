package com.annwyn.autolycus.extra.utils.generator;

import java.util.UUID;

public class UUIdGeneratorUtils implements IdGeneratorUtils {

    @Override
    public String generator() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
