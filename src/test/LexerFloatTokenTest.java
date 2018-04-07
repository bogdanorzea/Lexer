package test;

import lexer.Lexer;
import lexer.Token;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerFloatTokenTest {

    @Test
    void readFloatToken() {
        DummyReader dummyReader = new DummyReader("1234.56");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenFloatValue(token, 1234.56f);
    }

}
