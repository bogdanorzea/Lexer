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
        assertEquals(tokenValue, t.getAttribute().getValue());
    }

    static void validateTokenType(Token t, TokenType identifier) {
        assertEquals(identifier, t.getType());
    }

    static void validateTokenFloatValue(Token t, float tokenFloatValue) {
        assertEquals(tokenFloatValue, t.getAttribute().getFloatValue());
    }

    static void validateTokenDoubleValue(Token t, double tokenDoubleValue) {
        assertEquals(tokenDoubleValue, t.getAttribute().getDoubleValue());
    }

    static void validateTokenCharValue(Token t, char tokenCharValue) {
        assertEquals(tokenCharValue, t.getAttribute().getCharValue());
    }

    static void validateTokenIntegerValue(Token t, int tokenIntegerValue) {
        assertEquals(tokenIntegerValue, t.getAttribute().getIntegerValue());
    }

}
