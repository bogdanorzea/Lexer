package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerIntegerTokenTest {

    @Test
    void readIntegerToken() {
        DummyReader dummyReader = new DummyReader("1234");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenIntegerValue(token, 1234);
    }

    private void validateTokenIntegerValue(Token t, int tokenIntegerValue) {
        assertEquals(TokenType.INTEGER, t.getType());
        assertEquals(tokenIntegerValue, t.getAttribute().getIntegerValue());
    }
}
