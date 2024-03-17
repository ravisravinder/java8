package java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "orange"),
                Arrays.asList("banana", "grape"),
                Arrays.asList("kiwi", "melon")
        );

        List<String> stringList
                = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<PersonRavi> personRavis = Arrays.asList(
                new PersonRavi("John", Arrays.asList("Java", "C++")),
                new PersonRavi("Alice", Arrays.asList("Python", "JavaScript"))
        );
        List<String> collect = personRavis.stream()
                .flatMap(p -> p.getStringList().stream())
                .distinct()
                .collect(Collectors.toList());

        List<Optional<String>> optionalList = Arrays.asList(
                Optional.of("Value1"),
                Optional.empty(),
                Optional.of("Value2"),
                Optional.of("Value3")
        );

        List<String> values = optionalList.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

    }
}


class PersonRavi{
    private String name;
    private List<String> stringList;

    public PersonRavi(String name, List<String> stringList) {
        this.name = name;
        this.stringList = stringList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}