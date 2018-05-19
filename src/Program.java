import lexer.Lexer;
import lexer.Token;
import lexer.TokenType;

import java.io.*;

public class Program {
    public static void main(String[] args) {

        System.out.println("Reading file from disk...");

        try (FileReader fileReader = new FileReader("resources/input.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Lexer lexer = new Lexer(bufferedReader);
            Token token = lexer.getToken();
            while (token != null) {
                System.out.println(
                        String.format("%sToken @%d,%d is type %s with value: %s",
                                token.getType() == TokenType.UNKNOWN ? "\u001B[31m": "\u001B[32m",
                                token.getLineNumber()+1,
                                token.getColumnNumber()+1,
                                token.getType(),
                                token.getAttribute().getValue())
                );
                token = lexer.getToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
