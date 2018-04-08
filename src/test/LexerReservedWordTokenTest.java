package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerReservedWordTokenTest {

    @Test
    void readTokenWithReservedName() {
        DummyReader dummyReader = new DummyReader("main");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenType(token, TokenType.RESERVED_WORD);
        TestUtils.validateTokenValue(token, "main");
    }

}
