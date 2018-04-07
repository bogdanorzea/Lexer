package test;

import lexer.Lexer;
import lexer.Token;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerReservedWordTokenTest {

    @Test
    void readTokenWithReservedName() {
        DummyReader dummyReader = new DummyReader("main");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenReservedValue(token, "main");
    }

    @Test
    void readTokenWithReservedType() {
        DummyReader dummyReader = new DummyReader("int");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenReservedType(token, "int");
    }

}
