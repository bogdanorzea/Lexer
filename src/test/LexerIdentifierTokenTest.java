package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerIdentifierTokenTest {
    @Test
    void readIdentifierWithSimpleLetter() {
        DummyReader dummyReader = new DummyReader("a");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "a");
        TestUtils.validateTokenType(token, TokenType.IDENTIFIER);
        TestUtils.validateTokenPosition(token, 0, 0);
    }

    @Test
    void readIdentifierFromOffsetColumn() {
        DummyReader dummyReader = new DummyReader("  a");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "a");
        TestUtils.validateTokenType(token, TokenType.IDENTIFIER);
        TestUtils.validateTokenPosition(token, 2, 0);
    }

    @Test
    void readIdentifierFromOffsetLine() {
        DummyReader dummyReader = new DummyReader("\na");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "a");
        TestUtils.validateTokenType(token, TokenType.IDENTIFIER);
        TestUtils.validateTokenPosition(token, 0, 1);
    }

    @Test
    void readIdentifierFromOffsetLinesAndColumns() {
        DummyReader dummyReader = new DummyReader("\n\r\n  a");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "a");
        TestUtils.validateTokenType(token, TokenType.IDENTIFIER);
        TestUtils.validateTokenPosition(token, 2, 2);
    }

    @Test
    void readIdentifierWithDoubleLetter() {
        DummyReader dummyReader = new DummyReader("ab");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "ab");
        TestUtils.validateTokenType(token, TokenType.IDENTIFIER);
    }

    @Test
    void readIdentifierWithLettersAndNumbers() {
        DummyReader dummyReader = new DummyReader("ab5");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "ab5");
        TestUtils.validateTokenType(token, TokenType.IDENTIFIER);
    }

    @Test
    void readIdentifierWithLettersAndUnderscores() {
        DummyReader dummyReader = new DummyReader("ab_");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "ab_");
        TestUtils.validateTokenType(token, TokenType.IDENTIFIER);
    }

}
