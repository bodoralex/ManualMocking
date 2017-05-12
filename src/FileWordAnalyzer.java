import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bodor on 2017.05.09..
 */
public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList<String> wordsByABC() throws IOException, ClassNotFoundException {

        String antiglyphed = glyphVanisher(filePartReader.readLines());
        String trimmed = new String(antiglyphed).replaceAll("\\s+", " ");

        ArrayList words = new ArrayList(Arrays.asList(trimmed.split(" ")));
        words.sort(String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public ArrayList wordsContainingSubString(String subString) throws IOException, ClassNotFoundException {
        ArrayList<String> accept = new ArrayList<>();
        for (String word : wordsByABC()) {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                accept.add(word);
            }
        }
        return accept;
    }

    private String glyphVanisher(String input) {
        char[] glyphs = {',', '.', '?', '!', '-'};
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char glyph : glyphs) {
                if (chars[i] == glyph) {
                    chars[i] = ' ';
                }
            }
        }
        return new String(chars);
    }
}
