package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerParenthesesTokenTest {

    @Test
    void readPlusOperatorToken() {
        DummyReader dummyReader = new DummyReader("[");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenType(token, TokenType.PARENTHESES);
    }

}
