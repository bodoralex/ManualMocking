import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by bodor on 2017.05.09..
 */
public class FileWordAnalyzerTest {
    FileWordAnalyzer fileWordAnalyzer;

    @Before
    public void setUp() throws Exception {
        FilePartReader filePartReader = new FilePartReader("./out/test/ManualMocking/test.txt", 2, 4);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void wordsByABC() throws Exception {
        ArrayList<String> test = new ArrayList<>();
        test.addAll(Arrays.asList("hááárrommm", "kettő", "kettő", "negyedik", "sor"));
        assertEquals(fileWordAnalyzer.wordsByABC(), test);
    }

    @Test
    public void onlyOneWordContainingSubString() throws Exception {
        String subString = "o";
        ArrayList<String> contains = new ArrayList<>();
        contains.add("hááárrommm");
        assertEquals(fileWordAnalyzer.wordsContainingSubString("rom"), contains);
    }
    @Test
    public void mumltipleWordsContainingSubString() throws Exception {
        String subString = "o";
        ArrayList<String> contains = new ArrayList<>();
        contains.addAll(Arrays.asList("kettő", "kettő", "negyedik"));
        assertEquals(fileWordAnalyzer.wordsContainingSubString("e"), contains);
    }


}