package lexer;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Lexer {
    private Reader reader;
    private int currentColumnNumber;
    private int currentLineNumber;
    private int nextChar;

    private final static Map<String, TokenType> reservedWords;
    private final static Map<String, TokenType> reservedTypes;
    private final static Map<String, TokenType> operators;
    private final static Map<String, TokenType> parentheses;


    static {
        reservedWords = new HashMap<>();
        reservedWords.put("import", TokenType.RESERVED_WORD);
        reservedWords.put("package", TokenType.RESERVED_WORD);
        reservedWords.put("class", TokenType.RESERVED_WORD);
        reservedWords.put("interface", TokenType.RESERVED_WORD);
        reservedWords.put("abstract", TokenType.RESERVED_WORD);
        reservedWords.put("extends", TokenType.RESERVED_WORD);
        reservedWords.put("super", TokenType.RESERVED_WORD);
        reservedWords.put("this", TokenType.RESERVED_WORD);
        reservedWords.put("const", TokenType.RESERVED_WORD);
        reservedWords.put("enum", TokenType.RESERVED_WORD);
        reservedWords.put("new", TokenType.RESERVED_WORD);
        reservedWords.put("public", TokenType.RESERVED_WORD);
        reservedWords.put("private", TokenType.RESERVED_WORD);
        reservedWords.put("protected", TokenType.RESERVED_WORD);
        reservedWords.put("static", TokenType.RESERVED_WORD);
        reservedWords.put("final", TokenType.RESERVED_WORD);
        reservedWords.put("finally", TokenType.RESERVED_WORD);
        reservedWords.put("main", TokenType.RESERVED_WORD);
        reservedWords.put("return", TokenType.RESERVED_WORD);
        reservedWords.put("if", TokenType.RESERVED_WORD);
        reservedWords.put("else", TokenType.RESERVED_WORD);
        reservedWords.put("while", TokenType.RESERVED_WORD);
        reservedWords.put("do", TokenType.RESERVED_WORD);
        reservedWords.put("for", TokenType.RESERVED_WORD);
        reservedWords.put("throw", TokenType.RESERVED_WORD);
        reservedWords.put("try", TokenType.RESERVED_WORD);
        reservedWords.put("catch", TokenType.RESERVED_WORD);
        reservedWords.put("switch", TokenType.RESERVED_WORD);
        reservedWords.put("case", TokenType.RESERVED_WORD);
        reservedWords.put("break", TokenType.RESERVED_WORD);

        reservedTypes = new HashMap<>();
        reservedWords.put("null", TokenType.RESERVED_WORD);
        reservedTypes.put("void", TokenType.RESERVED_TYPE);
        reservedTypes.put("byte", TokenType.RESERVED_TYPE);
        reservedTypes.put("short", TokenType.RESERVED_TYPE);
        reservedTypes.put("int", TokenType.RESERVED_TYPE);
        reservedTypes.put("long", TokenType.RESERVED_TYPE);
        reservedTypes.put("float", TokenType.RESERVED_TYPE);
        reservedTypes.put("double", TokenType.RESERVED_TYPE);
        reservedTypes.put("boolean", TokenType.RESERVED_TYPE);
        reservedTypes.put("char", TokenType.RESERVED_TYPE);

        operators = new HashMap<>();
        operators.put("+", TokenType.OPERATOR);
        operators.put("-", TokenType.OPERATOR);
        operators.put("*", TokenType.OPERATOR);
        operators.put("/", TokenType.OPERATOR);
        operators.put("^", TokenType.OPERATOR);
        operators.put("%", TokenType.OPERATOR);

        parentheses = new HashMap<>();
        parentheses.put("(", TokenType.PARENTHESES);
        parentheses.put(")", TokenType.PARENTHESES);
        parentheses.put("[", TokenType.PARENTHESES);
        parentheses.put("]", TokenType.PARENTHESES);
        parentheses.put("{", TokenType.PARENTHESES);
        parentheses.put("}", TokenType.PARENTHESES);
    }

    public Lexer(Reader reader) {
        this.reader = reader;
        nextChar = getChar();
    }

    private int getChar() {
        try {
            return reader.read();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Token getToken() {
        skipWhitespace();

        if (Character.isLetter(nextChar)) {
            StringBuilder builder = new StringBuilder(Character.toString((char) nextChar));
            currentColumnNumber++;
            nextChar = getChar();

            while (Character.isLetterOrDigit(nextChar) || nextChar == '_') {
                builder.append((char) nextChar);
                currentColumnNumber++;
                nextChar = getChar();
            }

            TokenType tokenType;

            if (reservedWords.containsKey(builder.toString())) {
                tokenType = TokenType.RESERVED_WORD;
            } else if (reservedTypes.containsKey(builder.toString())) {
                tokenType = TokenType.RESERVED_TYPE;
            } else {
                tokenType = TokenType.IDENTIFIER;
            }

            String tokenStringValue = builder.toString();
            return new Token(tokenType,
                    new TokenAttribute(tokenStringValue),
                    currentColumnNumber - tokenStringValue.length(), currentLineNumber
            );
        }

        if (Character.isDigit(nextChar)) {
            StringBuilder builder = new StringBuilder(Character.toString((char) nextChar));
            currentColumnNumber++;
            nextChar = getChar();

            while (Character.isDigit(nextChar)) {
                builder.append((char) nextChar);
                currentColumnNumber++;
                nextChar = getChar();
            }

            if (nextChar == '.') {
                currentColumnNumber++;
                nextChar = getChar();

                if (Character.isDigit(nextChar)) {
                    builder.append('.');

                    while (Character.isDigit(nextChar)) {
                        builder.append((char) nextChar);
                        currentColumnNumber++;
                        nextChar = getChar();
                    }

                    String tokenStringValue = builder.toString();

                    return new Token(TokenType.FLOAT,
                            new TokenAttribute(Float.parseFloat(tokenStringValue)),
                            currentColumnNumber - tokenStringValue.length(),
                            currentLineNumber);
                }
            }

            String tokenStringValue = builder.toString();

            return new Token(TokenType.INTEGER,
                    new TokenAttribute(Integer.parseInt(tokenStringValue)),
                    currentColumnNumber - tokenStringValue.length(),
                    currentLineNumber);
        }

        if (operators.containsKey(String.valueOf((char) nextChar))) {
            String tokenStringValue = String.valueOf((char) nextChar);

            currentColumnNumber++;
            nextChar = getChar();

            return new Token(
                    TokenType.OPERATOR,
                    new TokenAttribute(tokenStringValue),
                    currentColumnNumber - tokenStringValue.length(),
                    currentLineNumber);
        }

        if (parentheses.containsKey(String.valueOf((char) nextChar))) {
            String tokenStringValue = String.valueOf((char) nextChar);

            currentColumnNumber++;
            nextChar = getChar();

            return new Token(
                    TokenType.PARENTHESES,
                    new TokenAttribute(tokenStringValue),
                    currentColumnNumber - tokenStringValue.length(),
                    currentLineNumber);
        }

        return null;
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(nextChar)) {
            if (isNextCharNewLine()) {
                currentLineNumber++;
                currentColumnNumber = -1;
            }

            currentColumnNumber++;
            nextChar = getChar();
        }
    }

    private boolean isNextCharNewLine() {
        if (nextChar == '\n') {
            return true;
        } else if (nextChar == '\r') {
            currentColumnNumber++;
            nextChar = getChar();
            return isNextCharNewLine();
        }

        return false;
    }
}
