package lexer;

public class Token {
    private TokenType type;
    private TokenAttribute attribute;
    private int lineNumber;
    private int columnNumber;

    public TokenType getType() {
        return type;
    }

    public TokenAttribute getAttribute() {
        return attribute;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public Token(TokenType type, TokenAttribute attribute, int columnNumber, int lineNumber) {
        this.type = type;
        this.attribute = attribute;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

}
