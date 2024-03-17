package java8.streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequestDuplicateChar {
    public static void main(String[] args) {
        String input = "programming";
        char mosFrequentDuplicate = findMostFrequestDuplicate(input);
        char mosFrequentDuplicateJava8 = findMostFrequentDuplicate(input);


        Optional<Character> firstRepeatingChar = findFirstRepeatingChar(input);

        if (firstRepeatingChar.isPresent()) {
            System.out.println("First repeating character: " + firstRepeatingChar.get());
        } else {
            System.out.println("No repeating characters found.");
        }




        Optional<Character> firstNonRepeatingChar = findFirstNonRepeatingChar(input);

        if (firstNonRepeatingChar.isPresent()) {
            System.out.println("First non-repeating character: " + firstNonRepeatingChar.get());
        } else {
            System.out.println("No non-repeating characters found.");
        }
    }

    private static char findMostFrequentDuplicate(String input) {
        Map<Character, Long> collect = input.chars()
                .mapToObj(c -> (char)c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<Character, Long>> max = collect.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .max(Map.Entry.comparingByValue());

        return max.map(Map.Entry::getKey).orElse('\0');

    }
    private static Optional<Character> findFirstRepeatingChar(String input) {
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();

        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> !charSet.add(ch)) // Add returns false for duplicates
                .findFirst();
    }
    private static Optional<Character> findFirstNonRepeatingChar(String input) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        input.chars()
                .mapToObj(c -> (char) c)
                .forEach(ch -> charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1));

        return charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    private static char findMostFrequestDuplicate(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        char mostFrequentDuplicate = '\0';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()>1 &&entry.getValue()>maxCount){
                mostFrequentDuplicate = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostFrequentDuplicate;
    }
}
