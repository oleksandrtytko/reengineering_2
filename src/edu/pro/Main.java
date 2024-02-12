package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static final String HARRY_POTTER_TEXT_PATH_STRING = "src/edu/pro/txt/harry.txt";
    public static final String DELIMITERS_REGEX = "[^A-Za-z ]";
    public static final String MORE_THAN_ONE_SPACE_REGEX = " +";
    public static final String NOT_DIGITS_REGEX = "[^0-9]";
    public static final String SPACE_STRING = " ";
    public static final String EMPTY_STRING = "";
    public static final int TOP_WORDS_TO_SHOW = 30;


    public static void main(String[] args) throws IOException {

        LocalDateTime startAppTime = LocalDateTime.now();
        Path textPath = Paths.get(HARRY_POTTER_TEXT_PATH_STRING);
        byte[] textBytes = Files.readAllBytes(textPath);
        String text = new String(textBytes);
        text = text.replaceAll(DELIMITERS_REGEX, SPACE_STRING).toLowerCase(Locale.ROOT);
        String[] words = text.split(MORE_THAN_ONE_SPACE_REGEX);
        Arrays.sort(words);
        String[] distinctWords = Arrays.stream(words)
            .collect(Collectors.toSet())
            .toArray(new String[]{});
        int[] wordsFrequency = new int[distinctWords.length];
        for (int i = 0; i < distinctWords.length; i++) {
            int wordPresenceCount = 0;
            for (int j = 0; j < words.length; j++) {
                if (distinctWords[i].equals(words[j])) {
                    wordPresenceCount++;
                }
            }
            wordsFrequency[i] = wordPresenceCount;
        }
        for (int i = 0; i < distinctWords.length; i++) {
            distinctWords[i] += " " + wordsFrequency[i];
        }
        Arrays.sort(distinctWords, Comparator.comparing(str ->
            Integer.valueOf(str.replaceAll(NOT_DIGITS_REGEX, EMPTY_STRING))));
        for (int i = 0; i < TOP_WORDS_TO_SHOW; i++) {
            System.out.println(distinctWords[distinctWords.length - 1 - i]);
        }
        LocalDateTime endAppTime = LocalDateTime.now();
        System.out.println("App execution duration: " + ChronoUnit.MILLIS.between(startAppTime, endAppTime) + " milliseconds");
    }
}
