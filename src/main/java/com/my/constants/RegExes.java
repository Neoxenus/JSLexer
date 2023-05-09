package com.my.constants;

public class RegExes {
    public static final String WHITESPACE = "\\s+";
    public static final String COMMENT = "(//.*)|(/\\*([\\s\\S]*?)\\*/)";
    public static final String NUMBER= "[-+]?\\d*\\.?\\d+";
    public static final String KEYWORD = "\\b(?:await|break|case|catch|class|const|continue|debugger|" +
            "default|delete|do|else|enum|export|extends|false|finally|for|function|if|implements|import|in|instanceof|" +
            "interface|let|new|null|package|public|protected|public|return|super|switch|static|this|throw|try|true|" +
            "typeof|var|void|while|with|yield)\\b";
    public static final String STRING = "\"([^\"\\\\]|\\\\.)*\"";
    public static final String IDENTIFIER = "[a-zA-Z_$][a-zA-Z0-9_$]*";
    public static final String OPERATOR = "\\+\\+|--|===|==|=~|!=|!==|<=|>=|=|<<|>>|>>>|\\+|-|\\*|/|%|\\|\\||&&|&|\\||\\^|~|!|<|>|\\?\\?\\?|\\?\\?|\\?|:|\\.|,";
    public static final String PUNCTUATION = "[\\(\\)\\[\\]\\{\\};]";

    private RegExes(){}
}
