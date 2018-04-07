package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerOperatorTokenTest {

    @Test
    void readPlusOperatorToken() {
        DummyReader dummyReader = new DummyReader("+");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenOperatorType(token);
    }

    private void validateTokenOperatorType(Token t) {
        assertEquals(TokenType.OPERATOR, t.getType());
    }
}
