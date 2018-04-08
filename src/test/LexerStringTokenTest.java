package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerStringTokenTest {

    @Test
    void readEmptyStringToken() {
        DummyReader dummyReader = new DummyReader(" \"\"");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenType(token, TokenType.STRING);
        TestUtils.validateTokenValue(token, "");
        TestUtils.validateTokenPosition(token, 1, 0);
    }

    @Test
    void readStringToken() {
        DummyReader dummyReader = new DummyReader("\"ana\"");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenType(token, TokenType.STRING);
        TestUtils.validateTokenValue(token, "ana");
        TestUtils.validateTokenPosition(token, 0, 0);
    }

    @Test
    void readStringTokenWithQuotes() {
        DummyReader dummyReader = new DummyReader("\"a\\\"\"");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenType(token, TokenType.STRING);
        TestUtils.validateTokenValue(token, "a\\\"");
        TestUtils.validateTokenPosition(token, 0, 0);
    }

    @Test
    void readStringTokenWithQuotesAtEnd() {
        DummyReader dummyReader = new DummyReader("\"\\\"\"");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenType(token, TokenType.STRING);
        TestUtils.validateTokenValue(token, "\\\"");
        TestUtils.validateTokenPosition(token, 0, 0);
    }

}
