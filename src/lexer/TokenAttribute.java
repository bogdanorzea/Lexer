package lexer;

public class TokenAttribute {
    private int integerValue;
    private float floatValue;
    private String value;

    public String getStringValue() {
        return value;
    }

    public int getIntegerValue() {
        return integerValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public TokenAttribute(int integerValue) {
        this.integerValue = integerValue;
    }

    public TokenAttribute(float floatValue) {
        this.floatValue = floatValue;
    }

    public TokenAttribute(String value) {
        this.value = value;
    }

}
