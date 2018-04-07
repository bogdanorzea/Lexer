package test;

import lexer.Lexer;
import lexer.Token;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerOperatorTokenTest {

    @Test
    void readPlusOperatorToken() {
        DummyReader dummyReader = new DummyReader("+");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenOperatorType(token);
    }

    @Test
    void readDivideOperatorToken() {
        DummyReader dummyReader = new DummyReader("10/5;");
        Lexer lexer = new Lexer(dummyReader);
        lexer.getToken();
        Token token = lexer.getToken();

        TestUtils.validateTokenOperatorType(token);
        TestUtils.validateTokenPosition(token, 2, 0);

    }

}
