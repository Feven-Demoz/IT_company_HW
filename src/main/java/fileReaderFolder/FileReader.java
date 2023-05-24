package fileReaderFolder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import static org.apache.commons.io.FileUtils.writeStringToFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class FileReader {

    private int numberOfManagers = 0;

    public static void countUniqueWords(String countUniqueWords) {
        String inputFile = "src/main/resources/text.txt";
        String outputFile = "src/main/resources/uniqueWordCount.txt";

        try {
            String content = FileUtils.readFileToString(new File(inputFile), StandardCharsets.UTF_8);
            String[] words = StringUtils.split(content, "[^a-zA-Z]+");

            Set<String> uniqueWords = new HashSet<>();
            for (String word : words) {
                uniqueWords.add(word.toLowerCase());
            }

            int uniqueWordCount = uniqueWords.size();
            String result = "The number of unique words is: " + uniqueWordCount;

            FileUtils.writeStringToFile(new File(outputFile), result, StandardCharsets.UTF_8);
            System.out.println("Result written to file: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}