package com.my.entities;

import com.my.entities.enums.TokenType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Token {

    private TokenType type;
    private String value;

    @Override
    public String toString() {
        return type.name() + "(" + value + ")";
    }
}