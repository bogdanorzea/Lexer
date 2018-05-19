package lexer;

public class TokenAttribute {

    private char charValue;
    private int integerValue;
    private float floatValue;
    private double doubleValue;

    private String value;

    public TokenAttribute() {

    }

    public char getCharValue() {
        return charValue;
    }

    public int getIntegerValue() {
        return integerValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public String getValue() {
        return value;
    }

    public double getDoubleValue() {
        return this.doubleValue;
    }

    public TokenAttribute(int integerValue) {
        this.integerValue = integerValue;
        this.value = String.valueOf(integerValue);
    }

    public TokenAttribute(char charValue) {
        this.charValue = charValue;
        this.value = String.valueOf(charValue);
    }

    public TokenAttribute(float floatValue) {
        this.floatValue = floatValue;
        this.value = String.valueOf(floatValue);
    }

    public TokenAttribute(double doubleValue) {
        this.doubleValue = doubleValue;
        this.value = String.valueOf(doubleValue);
    }

    public TokenAttribute(String value) {
        this.value = value;
    }

}
