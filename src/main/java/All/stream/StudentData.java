package All.stream;
//https://medium.com/@abhishek.talakeriv/java8-stream-api-commonly-asked-interview-questions-db26d7328131

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StudentData {
    public static void main(String[] args) {
        List<Student> list =Arrays.asList(  new Student(1, "Aditya", "Mall", 30, "Male", "Mechanical Engineering", 2014, "Mumbai", 122),
                new Student(2, "Pulkith", "Singh", 26, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankita", "Patil", 25, "Female", "Computer Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Darshan", "Mukd", 23, "Male", "Instrumentation Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Satyam", "Pandey", 26, "Male", "Biotech Engineering", 2017, "Mumbai", 98)
        );

        // Group the student by dept names
        Map<String,List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName));
        System.out.println("Students grouped by Department " +collect);

        //FInd the count of student in each department
        Map<String,Long> collect1 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        System.out.println("Count of Students in each Department" + collect1);

        //Find all department names
        List<String> deptName  = list.stream().map(t->t.getDepartmentName())
                .distinct().collect(Collectors.toList());
        System.out.println("Deaprtment Names " + deptName);

        //4. Find the list of students whose age is less than 25.
        List<Student> collect2 = list.stream().filter(t->t.getAge()<25).collect(Collectors.toList());
        System.out.println("List of Students whose Age is leass than 25 " + collect2);

        //5.find the max age of student
        OptionalInt max = list.stream().mapToInt(t -> t.getAge()).max();
        System.out.println("Max age of students " + max.getAsInt());

        //6. Find the average age of male and female students.
        Map<String, Double> collect3 = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of Male and Female students " + collect3);

        //7. Find the young student in all departments.
        int min = list.stream().mapToInt(Student::getAge)
                .min().getAsInt();

        System.out.println("Minimum age of student is " + min);
        // Or
        Student student = list.stream().min(Comparator.comparing(Student::getAge)).get();
        System.out.println("Young student is " + student);

        //8. Find the senior female student in all departments.
        int seniorFemaleStudent = list.stream().filter(t -> t.getGender().equals("Female"))
                .mapToInt(Student::getAge)
                .max().getAsInt();
        System.out.println("Senior Female student is " + seniorFemaleStudent);
        //Or
        Student student1 = list.stream().filter(t->t.getGender().equals("Female"))
                .max(Comparator.comparing(Student::getAge))
                .get();
        System.out.println("Senior Female student is " + student1);


        //9. Find the list of students whose rank is between 50 and 100.

        List<Student> collect4 = list.stream().filter(t -> t.getRank() > 50 && t.getRank() < 100)
                .collect(Collectors.toList());

        System.out.println("students whose rank is between 50 and 100 " + collect4);

        //10. Find the department who is having maximum number of students.

        Map.Entry<String, Long> stringLongEntry = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println("Department having maximum number of students " + stringLongEntry);

        //11. Find the Students who stays in Mumbai and sort them by their names.
        List<Student> mumbai = list.stream().filter(t -> t.getCity().equals("Mumbai"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
        System.out.println(mumbai);


        //12. Find the total count of students.
        long count = list.stream().count();
        System.out.println("Total count " + count);

        //13.  Find the average rank in all departments.
        Map<String, Double> collect5 = list.stream().collect(Collectors.groupingBy(
                Student::getDepartmentName, Collectors.averagingInt(Student::getRank)
        ));

        System.out.println("Average ranks " + collect5);

        //14. Find the highest rank in each department.
        Map<String, Optional<Student>> collect6 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName,
                Collectors.minBy(Comparator.comparing(Student::getRank))));

        System.out.println(collect6);

        //15. Find the list of students , which are sorted by their rank.
        List<Student> collect7 = list.stream().sorted(Comparator.comparing(Student::getRank))
                .collect(Collectors.toList());
        System.out.println(collect7);

//        16. Find the second highest rank student.
        Student student2 = list.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(1).findFirst()
                .get();
        System.out.println("Student "  + student2);

//17. Find the ranks of students in all department in ascending order.

        Map<String, List<Student>> collect8 = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list1 -> list1.stream()
                        .sorted(Comparator.comparing(Student::getRank))
                        .collect(Collectors.toList()))));
        System.out.println(collect8);


    }
}
