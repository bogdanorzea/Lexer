package test;

import lexer.Token;
import lexer.TokenType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtils {
    static void validateTokenPosition(Token t, int columnNumber, int lineNumber) {
        assertEquals(columnNumber, t.getColumnNumber());
        assertEquals(lineNumber, t.getLineNumber());
    }

    static void validateTokenValue(Token t, String tokenValue) {
        assertEquals(TokenType.IDENTIFIER, t.getType());
        assertEquals(tokenValue, t.getAttribute().getStringValue());
    }

    static void validateTokenFloatValue(Token t, float tokenFloatValue) {
        assertEquals(TokenType.FLOAT, t.getType());
        assertEquals(tokenFloatValue, t.getAttribute().getFloatValue());
    }

    static void validateTokenIntegerValue(Token t, int tokenIntegerValue) {
        assertEquals(TokenType.INTEGER, t.getType());
        assertEquals(tokenIntegerValue, t.getAttribute().getIntegerValue());
    }

    static void validateTokenOperatorType(Token t) {
        assertEquals(TokenType.OPERATOR, t.getType());
    }

    static void validateTokenParenthesesType(Token t) {
        assertEquals(TokenType.PARENTHESES, t.getType());
    }

    static void validateTokenReservedType(Token t, String tokenValue) {
        assertEquals(TokenType.RESERVED_TYPE, t.getType());
        assertEquals(tokenValue, t.getAttribute().getStringValue());
    }

    static void validateTokenReservedValue(Token t, String tokenValue) {
        assertEquals(TokenType.RESERVED_WORD, t.getType());
        assertEquals(tokenValue, t.getAttribute().getStringValue());
    }

    static void validateTokenSeparatorType(Token t) {
        assertEquals(TokenType.SEPARATOR, t.getType());
    }
}
