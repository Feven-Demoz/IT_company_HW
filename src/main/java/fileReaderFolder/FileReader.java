package fileReaderFolder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.Arrays;


public class FileReader {


    public static void countUniqueWords(String countUniqueWords) {
        String inputFile = "src/main/resources/text.txt";
        String outputFile = "src/main/resources/uniqueWordCount.txt";

        try {
            List<String> words = Files.readAllLines(Paths.get(inputFile))
                    .stream()
                    .flatMap(line -> Arrays.stream(line.split("[^a-zA-Z]+")))
                    .collect(Collectors.toList());

            Set<String> uniqueWords = new HashSet<>(words);

            int uniqueWordCount = uniqueWords.size();
            String result = "The number of unique words is: " + uniqueWordCount;

            FileUtils.writeStringToFile(new File(outputFile), result, StandardCharsets.UTF_8);
            System.out.println("Result written to file: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
















