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

    static {
        reservedWords = new HashMap<>();
        reservedWords.put("class", TokenType.RESERVED_WORD);
        reservedWords.put("public", TokenType.RESERVED_WORD);
        reservedWords.put("static", TokenType.RESERVED_WORD);
        reservedWords.put("final", TokenType.RESERVED_WORD);
        reservedWords.put("main", TokenType.RESERVED_WORD);
        reservedWords.put("void", TokenType.RESERVED_WORD);
        reservedWords.put("int", TokenType.RESERVED_WORD);
        reservedWords.put("float", TokenType.RESERVED_WORD);
        reservedWords.put("double", TokenType.RESERVED_WORD);
        reservedWords.put("boolean", TokenType.RESERVED_WORD);
        reservedWords.put("char", TokenType.RESERVED_WORD);
        reservedWords.put("if", TokenType.RESERVED_WORD);
        reservedWords.put("else", TokenType.RESERVED_WORD);
        reservedWords.put("while", TokenType.RESERVED_WORD);
        reservedWords.put("do", TokenType.RESERVED_WORD);
        reservedWords.put("for", TokenType.RESERVED_WORD);
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

            String tokenStringValue = builder.toString();
            TokenType tokenType = TokenType.IDENTIFIER;

            if (reservedWords.containsKey(tokenStringValue)) {
                tokenType = TokenType.RESERVED_WORD;
            }

            return new Token(tokenType,
                    new TokenAttribute(tokenStringValue),
                    currentLineNumber,
                    currentColumnNumber - tokenStringValue.length());
        }

        return null;
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(nextChar)) {
            if (isNextCharNewLine()){
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
