package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class LexerTest {
    @Test
    void readInvalidToken() {
        DummyReader dummyReader = new DummyReader("");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        assertNull(token);
    }

    @Test
    void readThreeTokens() {
        DummyReader dummyReader = new DummyReader("a + 5");
        Lexer lexer = new Lexer(dummyReader);
        Token token;

        token = lexer.getToken();
        assertNotNull(token);
        token = lexer.getToken();
        assertNotNull(token);
        token = lexer.getToken();
        assertNotNull(token);

        token = lexer.getToken();
        assertNull(token);
    }
}
