package com.my;

import com.my.entities.Token;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    @Getter
    private static List<Token> tokens = new ArrayList<>();


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

    private static void printSequence(JavaScriptLexer lexer) {
        tokens = new ArrayList<>();
        while (lexer.hasNextToken()) {
            Token token = lexer.nextToken();
            tokens.add(token);
            System.out.println(token);

        }
    }
}
