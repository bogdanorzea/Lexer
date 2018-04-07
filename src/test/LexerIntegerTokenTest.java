package test;

import lexer.Lexer;
import lexer.Token;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerIntegerTokenTest {

    @Test
    void readIntegerToken() {
        DummyReader dummyReader = new DummyReader("1234");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenIntegerValue(token, 1234);
    }

}
