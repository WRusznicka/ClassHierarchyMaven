package entities;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TextReader {
    private static Map<String, Integer> wordCount = new TreeMap<>();

    public static void main() {
        try {
            for (String word : StringUtils.split(FileUtils.readFileToString(FileUtils.getFile("src/main/resources/Text.txt"), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z\\s]", ""))) {
                wordCount.put(StringUtils.toRootLowerCase(word), wordCount.getOrDefault(word, 0) + 1);}
            FileUtils.writeLines(new File("src/main/resources/Result.txt"), wordCount.entrySet());
        } catch (Exception e) {
            throw new RuntimeException();}
    }
}
