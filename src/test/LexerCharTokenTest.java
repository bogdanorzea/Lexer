package test;

import lexer.Lexer;
import lexer.Token;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerCharTokenTest {

    @Test
    void readCharToken() {
        DummyReader dummyReader = new DummyReader(" 'a'");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenCharValue(token, 'a');
        TestUtils.validateTokenPosition(token, 1, 0);
    }

    @Test
    void readEscapedToken() {
        DummyReader dummyReader = new DummyReader("'\''");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenCharValue(token, '\'');
        TestUtils.validateTokenPosition(token, 0, 0);
    }

}
