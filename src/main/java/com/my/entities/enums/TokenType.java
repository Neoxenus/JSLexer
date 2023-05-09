package com.my.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public enum TokenType {
    KEYWORD("\u001B[34m"),
    WHITESPACE("\u001B[30m"),
    COMMENT("\u001B[37m"),
    NUMBER("\u001B[31m"),
    STRING("\u001B[32m"),
    IDENTIFIER("\u001B[33m"),

    OPERATOR("\u001B[35m"),
    PUNCTUATION("\u001B[36m"),
    ERROR("\u001B[38m");

    @Getter
    private final String color;
}
