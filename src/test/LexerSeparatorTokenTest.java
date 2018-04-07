package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerSeparatorTokenTest {

    @Test
    void readPlusOperatorToken() {
        DummyReader dummyReader = new DummyReader("a;");
        Lexer lexer = new Lexer(dummyReader);
        lexer.getToken();
        Token tokenSeparator = lexer.getToken();

        validateTokenSeparatorType(tokenSeparator);
    }

    private void validateTokenSeparatorType(Token t) {
        assertEquals(TokenType.SEPARATOR, t.getType());
    }
}
