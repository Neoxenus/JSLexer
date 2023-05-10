package com.my;

import com.my.entities.Token;
import com.my.entities.enums.TokenType;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.my.constants.RegExes.*;

public class JavaScriptLexer {

    // Define regular expressions for tokens
    private static final Map<TokenType, String> REG_EX = new HashMap<>();
    static {
        REG_EX.put(TokenType.COMMENT, COMMENT);
        REG_EX.put(TokenType.KEYWORD, KEYWORD);
        REG_EX.put(TokenType.WHITESPACE, WHITESPACE);
        REG_EX.put(TokenType.NUMBER, NUMBER);
        REG_EX.put(TokenType.STRING, STRING);
        REG_EX.put(TokenType.IDENTIFIER, IDENTIFIER);
        REG_EX.put(TokenType.OPERATOR, OPERATOR);
        REG_EX.put(TokenType.PUNCTUATION, PUNCTUATION);
    }

    // Regular expression pattern for all tokens
    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "(" + NUMBER + ")" +
                    "|(" + COMMENT + ")" +
                    "|(" + KEYWORD + ")" +
                    "|(" + WHITESPACE + ")" +
                    "|(" + STRING + ")" +
                    "|(" + IDENTIFIER + ")" +
                    "|(" + OPERATOR + ")" +
                    "|(" + PUNCTUATION + ")" +
                    "|(.+)"
    );
    private final Matcher matcher;

    public JavaScriptLexer(String input) {
        this.matcher = TOKEN_PATTERN.matcher(input);
    }

    public boolean hasNextToken() {
        return matcher.find();
    }

    public Token nextToken() {
        String tmp = matcher.group();
        for (TokenType type : TokenType.values()) {
            if(type == TokenType.ERROR) continue;
            if (tmp.matches(REG_EX.get(type))) {
                return new Token(type, tmp);
            }
        }
        return new Token(TokenType.ERROR, tmp);
    }
}