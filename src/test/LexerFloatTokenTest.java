package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerFloatTokenTest {

    @Test
    void readFloatToken() {
        DummyReader dummyReader = new DummyReader("1234.56");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenFloatValue(token, 1234.56f);
    }

    private void validateTokenFloatValue(Token t, float tokenFloatValue) {
        assertEquals(TokenType.FLOAT, t.getType());
        assertEquals(tokenFloatValue, t.getAttribute().getFloatValue());
    }

}
