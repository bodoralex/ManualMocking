import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by bodor on 2017.05.09..
 */
public class FilePartReaderTest {

    @Test(expected = FileNotFoundException.class)
    public void invalidFileName() throws Exception {
        FilePartReader filePartReader = new FilePartReader("./lol/tadywdualMocking/test.txt", 1, 2);
        filePartReader.readLines();
    }

    @Test(expected = IllegalArgumentException.class)
    public void instantiationFromIsUnderOne() throws Exception {
        FilePartReader filePartReader = new FilePartReader("./out/test/ManualMocking/test.txt", 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void instantiationFromIsBiggerThanTo() throws Exception {
        FilePartReader filePartReader = new FilePartReader("./out/test/ManualMocking/test.txt", 2, 1);
    }

    @Test
    public void readLines() throws Exception {
        FilePartReader filePartReader = new FilePartReader("./out/test/ManualMocking/test.txt", 2, 3);
        assertEquals(filePartReader.readLines(), "kettő, kettő\nhááárrommm!");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void outOfBounds() throws Exception {
        FilePartReader filePartReader = new FilePartReader("./out/test/ManualMocking/test.txt", 1, 30);
        filePartReader.readLines();
    }

}