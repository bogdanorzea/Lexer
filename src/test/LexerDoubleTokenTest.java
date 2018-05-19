package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerDoubleTokenTest {

    @Test
    void readDoubleToken() {
        DummyReader dummyReader = new DummyReader("12e-25");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenDoubleValue(token, 12e-25);
        TestUtils.validateTokenType(token, TokenType.DOUBLE);
    }

}
