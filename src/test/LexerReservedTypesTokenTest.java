package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerReservedTypesTokenTest {

    @Test
    void readTokenWithReservedType() {
        DummyReader dummyReader = new DummyReader("int");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        validateTokenReservedType(token, "int");
    }

    private void validateTokenReservedType(Token t, String tokenValue) {
        assertEquals(TokenType.RESERVED_TYPE, t.getType());
        assertEquals(tokenValue, t.getAttribute().getStringValue());
    }

}
