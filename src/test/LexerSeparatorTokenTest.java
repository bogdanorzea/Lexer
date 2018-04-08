package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerSeparatorTokenTest {

    @Test
    void readPlusOperatorToken() {
        DummyReader dummyReader = new DummyReader("a;");
        Lexer lexer = new Lexer(dummyReader);
        lexer.getToken();
        Token token = lexer.getToken();

        TestUtils.validateTokenType(token, TokenType.SEPARATOR);
    }

}
