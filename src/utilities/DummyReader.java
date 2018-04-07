package utilities;

import java.io.IOException;
import java.io.Reader;

public class DummyReader extends Reader {
    private String dummyString;
    private int position = 0;

    private DummyReader() {
    }

    public DummyReader(String dummyString) {
        this.dummyString = dummyString;
    }

    public int read() {
        if (position >= dummyString.length()) {
            return -1;
        }

        return dummyString.charAt(position++);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
