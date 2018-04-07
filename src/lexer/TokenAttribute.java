package lexer;

public class TokenAttribute {
    public String getValue() {
        return value;
    }

    private String value;

    public TokenAttribute(String value) {
        this.value = value;
    }
}
