package java8.streams;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8ToArray {
    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("a","b","c");
        Stream<String> stringStream1 = Stream.of("a","b","c");

        String[] strings = stringStream1.toArray(String[]::new);


        //  stringStream.mapT
        String []  stringArray = stringStream.toArray(size-> new String[size]);
        String s = Arrays.toString(stringArray);
        System.out.println(s);


        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");

// Convert each fruit to uppercase and join them into a comma-separated string
        String result = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(result);

        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Doe", 25),
                new Person("Smith", 30)
        );

// Group people by age
        Map<Integer, List<Person>> groupedByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(groupedByAge);

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

// Flatten the nested lists into a single list
        List<Integer> flatList = nestedLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flatList);

        List<String> names = Arrays.asList("John", "Doe", "Jane", "Smith");

// Find the first name starting with 'A'
        Optional<String> firstNameWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .findFirst();

        firstNameWithA.ifPresentOrElse(
                result1 -> System.out.println("First name starting with 'A': " + result),
                () -> System.out.println("No name found starting with 'A'")
        );

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Sum all elements in the list using reduce
        int sum = numbers.stream().reduce(0, Integer::sum);

        System.out.println("Sum: " + sum);


        List<Integer> numbers1= Arrays.asList(1, 2, 2, 3, 4, 4, 5);

// Get distinct elements from the list
        List<Integer> distinctNumbers = numbers1.stream().distinct().collect(Collectors.toList());

        System.out.println(distinctNumbers);

        List<String> names1 = Arrays.asList("John", "Doe", "Jane", "Smith");

// Sort names alphabetically
        List<String> sortedNames = names1.stream().sorted().collect(Collectors.toList());

        System.out.println(sortedNames);

        List<Integer> numbers12 = Arrays.asList(1, 2, 3, 4, 5);

// Perform operations in parallel
        int sumParallel = numbers12.parallelStream().reduce(0, Integer::sum);

        System.out.println("Sum using parallel stream: " + sumParallel);


        List<String> names3 = Arrays.asList("John", "Doe", "Jane", "Smith");

// Print each name before collecting them into a List
        List<String> collectedNames = names3.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("Collected Names: " + collectedNames);

        List<String> names4 = Arrays.asList("John", "Doe", "Jane", "Smith");

// Check if any name contains 'o'
        boolean anyMatch = names4.stream().anyMatch(name -> name.contains("o"));
        System.out.println("Any name contains 'o': " + anyMatch);

// Check if all names have length greater than 3
        boolean allMatch = names4.stream().allMatch(name -> name.length() > 3);
        System.out.println("All names have length greater than 3: " + allMatch);

        List<Integer> numbers_1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Skip the first 5 elements and limit the result to 3 elements
        List<Integer> result_1 = numbers_1.stream()
                .skip(5)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(result_1);

        List<String> names_2 = Arrays.asList("John", "Doe", "Jane", "Smith");

// Partition names into two groups based on name length
        Map<Boolean, List<String>> partitionedNames = names_2.stream()
                .collect(Collectors.partitioningBy(name -> name.length() > 3));

        System.out.println("Partitioned Names: " + partitionedNames);

        List<String> names_3 = Arrays.asList("John", "Doe", "Jane", "Smith");

// Convert names to uppercase and collect them into a TreeSet
        Set<String> upperCaseNames = names_3.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(upperCaseNames);

        List<String> list1 = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("c", "d");

// Concatenate two lists
        List<String> combinedList = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());

        System.out.println(combinedList);

        List<Person> people_1 = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Doe", 25),
                new Person("Smith", 30)
        );

// Get distinct people based on age
        List<Person> distinctPeople = people_1.stream()
                .collect(Collectors.toMap(Person::getAge, Function.identity(), (p1, p2) -> p1))
                .values()
                .stream()
                .collect(Collectors.toList());

        System.out.println(distinctPeople);

    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }
}
