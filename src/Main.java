import CourseTask.Exceptions.CheckValues;
import CourseTask.Exceptions.WrongInputOutputException;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите текст: ");
            String something = CheckValues.CheckString(scanner.nextLine()).toLowerCase();
            String result = something.replaceAll("[!+.^:;,_?*-]", "");
            String[] words = result.split("\\s+");
            System.out.println("В тексте " + Stream.of(words).count() + " слов.");
            System.out.println("TOP-10 самых популярных слов в тексте:");
            HashMap<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                if (!wordCount.containsKey(word)) {
                    wordCount.put(word, 0);
                }
                wordCount.put(word, wordCount.get(word) + 1);
            }
            TreeMap<String, Integer> topTen = new TreeMap<>();
            topTen.putAll(wordCount);
            topTen.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .limit(10)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ))
                    .forEach((s, i) -> System.out.println(String.format("%s - %s", i, s)));
        } catch (WrongInputOutputException e) {
            e.printStackTrace();

        }



    }
}