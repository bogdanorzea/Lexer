package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerReservedWordTokenTest {

    @Test
    void readTokenWithReservedName() {
        DummyReader dummyReader = new DummyReader("main");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenReservedValue(token, "main");
    }

    @Test
    void readTokenWithReservedType() {
        DummyReader dummyReader = new DummyReader("int");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenReservedType(token, "int");
    }

    private void validateTokenReservedValue(Token t, String tokenValue) {
        assertEquals(TokenType.RESERVED_WORD, t.getType());
        assertEquals(tokenValue, t.getAttribute().getStringValue());
    }

    private void validateTokenReservedType(Token t, String tokenValue) {
        assertEquals(TokenType.RESERVED_TYPE, t.getType());
        assertEquals(tokenValue, t.getAttribute().getStringValue());
    }

}
