package test;

import lexer.*;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.*;

class LexerIdentifierTokenTest {
    @Test
    void readIdentifierWithSimpleLetter() {
        DummyReader dummyReader = new DummyReader("a");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenStringValue(token, "a");
        validateTokenPosition(token, 0, 0);
    }

    @Test
    void readIdentifierFromOffsetColumn() {
        DummyReader dummyReader = new DummyReader("  a");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenStringValue(token, "a");
        validateTokenPosition(token, 2, 0);
    }

    @Test
    void readIdentifierFromOffsetLine() {
        DummyReader dummyReader = new DummyReader("\na");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenStringValue(token, "a");
        validateTokenPosition(token, 0, 1);
    }

    @Test
    void readIdentifierFromOffsetLinesAndColumns() {
        DummyReader dummyReader = new DummyReader("\n\r\n  a");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenStringValue(token, "a");
        validateTokenPosition(token, 2, 2);
    }

    @Test
    void readIdentifierWithDoubleLetter() {
        DummyReader dummyReader = new DummyReader("ab");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenStringValue(token, "ab");
    }

    @Test
    void readIdentifierWithLettersAndNumbers() {
        DummyReader dummyReader = new DummyReader("ab5");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenStringValue(token, "ab5");
    }

    @Test
    void readIdentifierWithLettersAndUnderscores() {
        DummyReader dummyReader = new DummyReader("ab_");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenStringValue(token, "ab_");
    }

    private void validateTokenStringValue(Token t, String tokenValue) {
        assertEquals(TokenType.IDENTIFIER, t.getType());
        assertEquals(tokenValue, t.getAttribute().getStringValue());
    }

    private void validateTokenPosition(Token t, int columnNumber, int lineNumber) {
        assertEquals(columnNumber, t.getColumnNumber());
        assertEquals(lineNumber, t.getLineNumber());
    }

}
