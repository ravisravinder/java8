package java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("apple", "banana", "orange");
        List<String> list2 = Arrays.asList("banana", "orange", "grape");


// Combine lists, removing duplicates, and convert to uppercase
        List<String> combinedList = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(combinedList);

        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Doe", 25),
                new Person("Smith", 30)
        );

// Collect people into a Map based on their names
   //     This is the merge function. In case there are duplicate keys (names),
        //     this function is invoked to resolve the conflict. In this specific case,
        //     it says that if there are two values for the same key, it will choose the value
        //     from the first occurrence (age1).
        Map<String, Integer> ageByName = people.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge, (age1, age2) -> age1));

        System.out.println(ageByName);

        List<Integer> numbers = Arrays.asList(2, 8, 5, 1, 10);

// Find the maximum and minimum numbers
        Optional<Integer> maxNumber = numbers.stream().max(Integer::compare);
        Optional<Integer> minNumber = numbers.stream().min(Integer::compare);

        System.out.println("Max: " + maxNumber.orElse(null));
        System.out.println("Min: " + minNumber.orElse(null));


        List<Integer> numbers_3 = Arrays.asList(2, 4, 6, 8, 10);

// Get statistics (count, sum, min, average, max) for the numbers
        IntSummaryStatistics stats = numbers_3.stream().mapToInt(Integer::intValue).summaryStatistics();

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        List<List<String>> nestedLists = Arrays.asList(
                Arrays.asList("apple", "orange"),
                Arrays.asList("banana", "apple"),
                Arrays.asList("grape", "orange")
        );

// Flatten and get distinct fruits
        List<String> distinctFruits = nestedLists.stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctFruits);


    }
}
