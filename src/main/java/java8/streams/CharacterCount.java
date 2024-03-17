package java8.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {
    public static void main(String[] args) {
        String input = "india";
        String result = input.chars()
                .mapToObj(c -> (char) c + String.valueOf(input.indexOf(c)))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        Map<Character, Long> charCountMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        charCountMap.forEach((character, count) ->
                System.out.println(character + " count " + count));

        System.out.println(result);

    }
}
