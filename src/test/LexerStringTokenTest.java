package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerStringTokenTest {

    @Test
    void readCharToken() {
        DummyReader dummyReader = new DummyReader("\"ana\"");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenType(token, TokenType.STRING);
        TestUtils.validateTokenValue(token, "ana");
        TestUtils.validateTokenPosition(token, 0, 0);
    }

}
