package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    /*
     * write in a text file
     * @param filePath       file path to write in
     * @param data           to write data
     */
    public static void writeIntoFile(String filePath, String data) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * read from a text file
     * @param filePath       file path to read from
     */
    public static String readFromFile(String filePath) {
        String data;
        try {
            data = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
