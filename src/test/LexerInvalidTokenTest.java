package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerInvalidTokenTest {

    @Test
    void readIdentifierWithBlockComment() {
        DummyReader dummyReader = new DummyReader("*/");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "*/");
        TestUtils.validateTokenType(token, TokenType.UNKNOWN);
        TestUtils.validateTokenPosition(token, 0, 0);
    }

}
