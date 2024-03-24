package All.stream;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeDemo {
    public static void main(String[] args) {
        List<ITEmployee> employees = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            //Create ITEmployee Objects
            ITEmployee emp1 = new ITEmployee("John Doe",30,
                    50000.0, Arrays.asList("Java","Python","SQL"),
                    getContactInfo("john.doe@example.com", "1234567890"),
                    dateFormat.parse("01/04/2020"),true,"IT");


            ITEmployee emp2 = new ITEmployee("Alice Smith", 34, 60000.0,
                    Arrays.asList("JavaScript", "HTML", "CSS"),
                    getContactInfo("alice.smith@example.com", "9876543210"),
                    dateFormat.parse("12/01/2018"), true,"IT");
            employees.add(emp2);

            ITEmployee emp3 = new ITEmployee("Robert Johnson", 28, 45000.0,
                    Arrays.asList("C++", "Python", "Data Analysis"),
                    getContactInfo("robert.johnson@example.com", "4567890123"),
                    dateFormat.parse("15/07/2019"), false,"MECH");
            employees.add(emp3);

            ITEmployee emp4 = new ITEmployee("Emily Brown", 32, 55000.0,
                    Arrays.asList("Java", "JavaScript", "Angular"),
                    getContactInfo("emily.brown@example.com", "7890123456"),
                    dateFormat.parse("05/03/2017"), true,"MECH");
            employees.add(emp4);

            ITEmployee emp5 = new ITEmployee("Michael Wilson", 29, 52000.0,
                    Arrays.asList("Python", "Machine Learning", "Big Data"),
                    getContactInfo("michael.wilson@example.com", "2345678901"),
                    dateFormat.parse("20/11/2018"), true,"CIVIL");
            employees.add(emp5);

            ITEmployee emp6 = new ITEmployee("Olivia Davis", 31, 48000.0,
                    Arrays.asList("HTML", "CSS", "UI/UX Design"),
                    getContactInfo("olivia.davis@example.com", "6789012345"),
                    dateFormat.parse("02/09/2019"), true,"CIVIL");
            employees.add(emp6);

            ITEmployee emp7 = new ITEmployee("James Miller", 33, 58000.0,
                    Arrays.asList("Java", "Spring Framework", "Hibernate"),
                    getContactInfo("james.miller@example.com", "8901234567"),
                    dateFormat.parse("14/06/2020"), true,"IT");
            employees.add(emp7);

            ITEmployee emp8 = new ITEmployee("Sophia Wilson", 27, 43000.0,
                    Arrays.asList("Python", "Data Science", "Data Visualization"),
                    getContactInfo("sophia.wilson@example.com", "4567890123"),
                    dateFormat.parse("23/02/2021"), true,"IT");
            employees.add(emp8);

            ITEmployee emp9 = new ITEmployee("Liam Anderson", 35, 62000.0,
                    Arrays.asList("Java", "Spring Boot", "Microservices"),
                    getContactInfo("liam.anderson@example.com", "6789012345"),
                    dateFormat.parse("17/10/2017"), false,"MECH");
            employees.add(emp9);

            ITEmployee emp10 = new ITEmployee("Ava Lee", 28, 51000.0,
                    Arrays.asList("JavaScript", "React", "Node.js"),
                    getContactInfo("ava.lee@example.com", "9012345678"),
                    dateFormat.parse("29/12/2018"), true,"CIVIL");
            employees.add(emp10);

            ITEmployee emp11 = new ITEmployee("Mason Harris", 30, 54000.0,
                    Arrays.asList("Python", "Machine Learning", "Natural Language Processing"),
                    getContactInfo("mason.harris@example.com", "3456789012"),
                    dateFormat.parse("16/08/2019"), true,"CSC");
            employees.add(emp11);

            ITEmployee emp12 = new ITEmployee("Isabella Martinez", 29, 47000.0,
                    Arrays.asList("HTML", "CSS", "Bootstrap"),
                    getContactInfo("isabella.martinez@example.com", "7890123456"),
                    dateFormat.parse("25/05/2020"), true,"CSC");
            employees.add(emp12);

            ITEmployee emp13 = new ITEmployee("William Wilson", 31, 60000.0,
                    Arrays.asList("Java", "Spring MVC", "RESTful APIs"),
                    getContactInfo("william.wilson@example.com", "1234567890"),
                    dateFormat.parse("03/05/2017"), true,"CSC");
            employees.add(emp13);

            ITEmployee emp14 = new ITEmployee("Charlotte Davis", 32, 52000.0,
                    Arrays.asList("Python", "Data Analysis", "SQL"),
                    getContactInfo("charlotte.davis@example.com", "5678901234"),
                    dateFormat.parse("22/11/2018"), false,"CSC");
            employees.add(emp14);

            ITEmployee emp15 = new ITEmployee("Benjamin Taylor", 34, 58000.0,
                    Arrays.asList("JavaScript", "React Native", "Firebase"),
                    getContactInfo("benjamin.taylor@example.com", "9012345678"),
                    dateFormat.parse("11/07/2019"), true,"IT");
            employees.add(emp15);
            for (ITEmployee emp : employees) {
                System.out.println(emp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    // Problem: Get a list of active employees with a salary greater than 50000
        List<ITEmployee> activeEmployeesWithHighSalary = employees.stream().filter(ITEmployee::isActive)
                .filter(emp -> emp.getSalary() > 50000)
                .collect(Collectors.toList());

        System.out.println(activeEmployeesWithHighSalary);

    // Problem: Get the total number of employees who possess Java and Python skills
        long count = employees.stream().filter(emp -> emp.getSkills().contains("Java")
                && emp.getSkills().contains("Python")).count();
        System.out.println("Number of employees with Java and Python skills: " + count);

    // Problem: Find the employee with the highest salary
        Optional<ITEmployee> employeeWithHighestSalary =
                employees.stream().max(Comparator.comparingDouble(ITEmployee::getSalary));
        employeeWithHighestSalary.ifPresent(emp->System.out.println("ITEmployee with highest salary: " + emp));

        // Problem: Group employees by their age
        Map<Integer,List<ITEmployee>> employeesByAge = employees.stream()
                .collect(Collectors.groupingBy(ITEmployee::getAge));
        employeesByAge.forEach((age, empList) -> System.out.println("Employees with age " + age + ": " + empList));


        // Problem: Calculate the average salary of all employees
        double averageSalary = employees.stream()
                .mapToDouble(ITEmployee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Average salary: " + averageSalary);


        // Problem: Find the employee with the most number of skills
        Optional<ITEmployee> mostSkilledEmployee = employees.stream().max(Comparator.comparingInt(emp->emp.getSkills().size()));
        mostSkilledEmployee.ifPresent(emp -> System.out.println("ITEmployee with the most skills: " + emp));

        // Problem: Calculate the total salary of active employees in each department

        Map<String, Double> departmentSalarySum = employees.stream()
                .filter(ITEmployee::isActive)
                .collect(Collectors.groupingBy(ITEmployee::getName,
                        Collectors.summingDouble(ITEmployee::getSalary)));
        departmentSalarySum.forEach((department, totalSalary) ->
                System.out.println("Total salary in " + department + ": " + totalSalary));

        // Problem: Find the employee who joined first in each department

        Map<String, Optional<ITEmployee>> earliestEmployeeByDept = employees.stream()
                .collect(Collectors.groupingBy(ITEmployee::getDepartment,
                        Collectors.minBy(Comparator.comparing(ITEmployee::getHireDate))));

        earliestEmployeeByDept.forEach((department, employee) ->
                employee.ifPresent(emp -> System.out.println("Earliest joined employee in " + department + ": " + emp)));

// Problem: Check if any employee has both a skill and a contact detail containing the keyword "example"

        boolean hasEmployeeWithSkillAndKeyword = employees.stream()
                .anyMatch(emp -> emp.getSkills().stream().anyMatch(skill ->
                        emp.getContactInfo().values().stream().anyMatch(contact ->
                                contact.contains("example"))));

        System.out.println("Has employee with skill and keyword: " + hasEmployeeWithSkillAndKeyword);


// Problem: Sort employees based on their skills (lexicographically) and then by salary (descending)

        List<ITEmployee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(ITEmployee::getSkills, Comparator.comparing(List::toString))
                        .thenComparingDouble(ITEmployee::getSalary).reversed())
                .collect(Collectors.toList());

        sortedEmployees.forEach(System.out::println);


        // Problem: Calculate the average age of employees in each department

        Map<String, Double> departmentAverageAge = employees.stream()
                .collect(Collectors.groupingBy(ITEmployee::getDepartment,
                        Collectors.averagingInt(ITEmployee::getAge)));

        departmentAverageAge.forEach((department, averageAge) ->
                System.out.println("Average age in " + department + ": " + averageAge));


// Problem: Find employees who have duplicate skills

        Map<List<String>, List<ITEmployee>> employeesWithDuplicateSkills = employees.stream()
                .collect(Collectors.groupingBy(ITEmployee::getSkills));

        employeesWithDuplicateSkills.values().stream()
                .filter(empList -> empList.size() > 1)
                .flatMap(List::stream)
                .distinct()
                .forEach(System.out::println);

// Problem: Calculate the total salary of employees for each year since their hire date

        Map<Integer, Double> yearlySalarySum = employees.stream()
                .collect(Collectors.groupingBy(emp -> getYear(emp.getHireDate()),
                        Collectors.summingDouble(ITEmployee::getSalary)));

        yearlySalarySum.forEach((year, totalSalary) ->
                System.out.println("Total salary in year " + year + ": " + totalSalary));


// Problem: Split employees into two groups based on their salary (above and below average)

        double averageSalary1 = employees.stream()
                .mapToDouble(ITEmployee::getSalary)
                .average()
                .orElse(0.0);

        Map<Boolean, List<ITEmployee>> employeesBySalaryGroup = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > averageSalary1));

        List<ITEmployee> aboveAverageSalary = employeesBySalaryGroup.get(true);
        List<ITEmployee> belowAverageSalary = employeesBySalaryGroup.get(false);

        System.out.println("Employees with salary above average: " + aboveAverageSalary);
        System.out.println("Employees with salary below average: " + belowAverageSalary);


// Problem: Increase the salary of employees with active status by 10% and decrease the salary of inactive employees by 5%

        List<ITEmployee> updatedEmployees = employees.stream()
                .map(emp -> {
                    double newSalary = emp.isActive()
                            ? emp.getSalary() * 1.10
                            : emp.getSalary() * 0.95;
                    emp.setSalary(newSalary);
                    return emp;
                })
                .collect(Collectors.toList());

        updatedEmployees.forEach(System.out::println);


// Problem: Calculate the cumulative years of experience for all employees

        int totalYearsOfExperience = employees.stream()
                .mapToInt(emp -> getYear(new Date()) - getYear(emp.getHireDate()))
                .sum();

        System.out.println("Total years of experience: " + totalYearsOfExperience);


// Problem: Calculate the cumulative years of experience for all employees

        int totalYearsOfExperience1 = employees.stream()
                .mapToInt(emp -> getYear(new Date()) - getYear(emp.getHireDate()))
                .sum();

        System.out.println("Total years of experience: " + totalYearsOfExperience1);

// Problem: Find the department with the highest average salary

        Optional<Map.Entry<String, Double>> departmentWithHighestAvgSalary = employees.stream()
                .collect(Collectors.groupingBy(ITEmployee::getDepartment,
                        Collectors.averagingDouble(ITEmployee::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        departmentWithHighestAvgSalary.ifPresent(department ->
                System.out.println("Department with highest average salary: " + department.getKey()));


// Problem: Get the top three employees with the most diverse (unique) skills

        List<ITEmployee> topThreeDiverseEmployees = employees.stream()
                .sorted(Comparator.comparingInt(emp -> emp.getSkills().size()))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top three employees with the most diverse skills: " + topThreeDiverseEmployees);



// Problem: Calculate the accumulated total salary of employees in each department over time

        Map<String, List<Double>> departmentAccumulatedSalary = employees.stream()
                .collect(Collectors.groupingBy(ITEmployee::getDepartment,
                        Collectors.mapping(ITEmployee::getSalary,
                                Collectors.collectingAndThen(Collectors.toList(), salaryList -> {
                                    double sum = 0;
                                    List<Double> accumulated = new ArrayList<>();
                                    for (Double salary : salaryList) {
                                        sum += salary;
                                        accumulated.add(sum);
                                    }
                                    return accumulated;
                                }))));

        departmentAccumulatedSalary.forEach((department, accumulatedSalaryList) ->
                System.out.println("Accumulated salary in " + department + ": " + accumulatedSalaryList));


// Problem: Find the employee with the most number of skills in each department

        Map<String, Optional<ITEmployee>> employeeWithMostSkillsByDept = employees.stream()
                .collect(Collectors.groupingBy(ITEmployee::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(emp -> emp.getSkills().size()))));

        employeeWithMostSkillsByDept.forEach((department, employee) ->
                employee.ifPresent(emp -> System.out.println("ITEmployee with the most skills in " + department + ": " + emp)));


// Problem: Partition employees into two groups based on their total years of experience (over and under 5 years)

        Map<Boolean, List<ITEmployee>> employeesByExperience = employees.stream()
                .collect(Collectors.partitioningBy(emp -> getTotalYearsOfExperience(emp) >= 5));

        List<ITEmployee> experiencedEmployees = employeesByExperience.get(true);
        List<ITEmployee> inexperiencedEmployees = employeesByExperience.get(false);

        System.out.println("Experienced employees (5+ years of experience): " + experiencedEmployees);
        System.out.println("Inexperienced employees (less than 5 years of experience): " + inexperiencedEmployees);



    }
    public static long getTotalYearsOfExperience(ITEmployee employee) {
        Date currentDate = new Date(); // Current date
        long diffInMillies = Math.abs(currentDate.getTime() - employee.getHireDate().getTime());
        long diffInYears = diffInMillies / (1000L * 60 * 60 * 24 * 365);
        return diffInYears;
    }

    private static Map<String, String> getContactInfo(String email, String phone){
        Map<String, String> contactInfo = new HashMap<>();
        contactInfo.put("Email",email);
        contactInfo.put("Phone",phone);
        return contactInfo;
    }
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
}
