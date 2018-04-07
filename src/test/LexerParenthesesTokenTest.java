package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerParenthesesTokenTest {

    @Test
    void readPlusOperatorToken() {
        DummyReader dummyReader = new DummyReader("[");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenParenthesesType(token);
    }

    private void validateTokenParenthesesType(Token t) {
        assertEquals(TokenType.PARENTHESES, t.getType());
    }
}
