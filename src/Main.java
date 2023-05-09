import CourseTask.Exceptions.CheckValues;
import CourseTask.Exceptions.WrongInputOutputException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите текст: ");
            String something = CheckValues.CheckString(scanner.nextLine()).toLowerCase();
            String[] words = something.split(" ");
            System.out.println("В тексте " + Stream.of(words).count() + " слов.");
            HashMap<String, Integer> wordToCount = new HashMap<>();
            for (String word : words) {
                if (!wordToCount.containsKey(word)) {
                    wordToCount.put(word, 0);
                }
                wordToCount.put(word, wordToCount.get(word) + 1);
            }
            for (String word : wordToCount.keySet()) {
                System.out.println(Stream.of(word).limit(5).collect(Collectors.toCollection(ArrayList::new)) + " - " + wordToCount.get(word));
            }

        } catch (WrongInputOutputException e) {
            System.err.println(e.getMessage());
        }
    }
}