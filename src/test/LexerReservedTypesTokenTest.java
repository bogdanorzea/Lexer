package test;

import lexer.Lexer;
import lexer.Token;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerReservedTypesTokenTest {

    @Test
    void readTokenWithReservedType() {
        DummyReader dummyReader = new DummyReader("int");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenReservedType(token, "int");
    }

    @Test
    void readTokenWithReservedTypeArray() {
        DummyReader dummyReader = new DummyReader("int[] a");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenReservedType(token, "int[]");
    }

}
