package test;

import utilities.DummyReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DummyReaderTest {
    @Test
    void readEmptyString() {
        DummyReader dummyReader = new DummyReader("");
        assertEquals(dummyReader.read(), -1);
    }

    @Test
    void readWhiteSpaceFromString() {
        DummyReader dummyReader = new DummyReader(" ");
        assertEquals(dummyReader.read(), ' ');
        assertEquals(dummyReader.read(), -1);
    }

    @Test
    void readSingleCharacterString() {
        DummyReader dummyReader = new DummyReader("a");
        assertEquals(dummyReader.read(), 'a');
        assertEquals(dummyReader.read(), -1);
    }

    @Test
    void readMultipleCharacterString() {
        DummyReader dummyReader = new DummyReader("abcd");
        assertEquals(dummyReader.read(), 'a');
        assertEquals(dummyReader.read(), 'b');
        assertEquals(dummyReader.read(), 'c');
        assertEquals(dummyReader.read(), 'd');
        assertEquals(dummyReader.read(), -1);
    }
}
