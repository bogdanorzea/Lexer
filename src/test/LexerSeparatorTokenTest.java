package test;

import lexer.Lexer;
import lexer.Token;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerSeparatorTokenTest {

    @Test
    void readPlusOperatorToken() {
        DummyReader dummyReader = new DummyReader("a;");
        Lexer lexer = new Lexer(dummyReader);
        lexer.getToken();
        Token tokenSeparator = lexer.getToken();

        TestUtils.validateTokenSeparatorType(tokenSeparator);
    }

}
