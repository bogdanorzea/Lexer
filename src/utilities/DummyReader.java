package utilities;

import java.io.IOException;
import java.io.Reader;

public class DummyReader extends Reader {
    private String dummyString;
    private int position = 0;
    private int markPosition = -1;

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
    public boolean markSupported() {
        return true;
    }

    @Override
    public void mark(int readAheadLimit) throws IOException {
        this.markPosition = position;
    }

    @Override
    public void reset() throws IOException {
        this.position = markPosition;
        markPosition = -1;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
