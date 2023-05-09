package com.my;

import com.my.entities.Token;
import com.my.entities.enums.TokenType;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        String input;
        try {
            URL res = Main.class.getClassLoader().getResource("input.txt");
            File file = Paths.get(Objects.requireNonNull(res).toURI()).toFile();
            Path path = Path.of(file.getAbsolutePath());
            input = Files.readString(path, StandardCharsets.UTF_8);

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

        JavaScriptLexer lexer = new JavaScriptLexer(input);
        printSequence(lexer);
    }

    private static void printHighlightedTokens(JavaScriptLexer lexer){
        while (lexer.hasNextToken()) {
            Token token = lexer.nextToken();
            System.out.println(token.getType().getColor() + token.getType() + ": " + token.getValue() + ANSI_RESET);
        }
    }

    private static void printSortedTokens(JavaScriptLexer lexer) {

        Map<TokenType, List<Token>> sortedMap = new TreeMap<>();

        while (lexer.hasNextToken()) {
            Token token = lexer.nextToken();
            sortedMap.computeIfAbsent(token.getType(), k -> new ArrayList<>())
                    .add(token);
        }

        sortedMap.forEach((type, tokens) -> {
            System.out.println(type + ":");
            tokens.forEach(token -> System.out.println("  " + token.getValue()));
        });

    }

    private static void printSequence(JavaScriptLexer lexer) {

        while (lexer.hasNextToken()) {
            Token token = lexer.nextToken();
            System.out.println(token.getType() + ": " + token.getValue());

        }
    }
}
