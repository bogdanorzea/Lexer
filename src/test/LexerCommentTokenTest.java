package test;

import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;
import org.junit.jupiter.api.Test;
import utilities.DummyReader;

class LexerCommentTokenTest {

    @Test
    void readIdentifierWithBlockComment() {
        DummyReader dummyReader = new DummyReader("/**/");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "/**/");
        TestUtils.validateTokenType(token, TokenType.COMMENT);
        TestUtils.validateTokenPosition(token, 0, 0);
    }

    @Test
    void readIdentifierWithStarInBlockComment() {
        DummyReader dummyReader = new DummyReader("/***/");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "/***/");
        TestUtils.validateTokenType(token, TokenType.COMMENT);
        TestUtils.validateTokenPosition(token, 0, 0);
    }

    @Test
    void readIdentifierWithNewLineInBlockComment() {
        DummyReader dummyReader = new DummyReader("/*\n*/");
        Lexer lexer = new Lexer(dummyReader);
        Token token = lexer.getToken();

        TestUtils.validateTokenValue(token, "/*\n*/");
        TestUtils.validateTokenType(token, TokenType.COMMENT);
        TestUtils.validateTokenPosition(token, 0, 0);
    }

}
