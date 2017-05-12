import java.io.*;

/**
 * Created by bodor on 2017.05.08..
 */
public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(String filePath, int fromLine, int toLine) throws IllegalArgumentException {
        if (fromLine > toLine || fromLine < 1) throw new IllegalArgumentException();
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws IOException, ClassNotFoundException {
        FileReader reader = new FileReader(filePath);
        StringBuilder file = new StringBuilder();
        int character;
        int enter = 0;
        while ((character = reader.read()) != -1) {
            file.append((char) character);
        }
        return file.toString();
    }

    public String readLines() throws IOException, ClassNotFoundException {
        String[] file = read().split("\n");
        StringBuilder result = new StringBuilder();
        for (int i = fromLine - 1; i < toLine; i++) {
            result.append(file[i]).append("\n");
        }
        return result.toString().trim();
    }

}
