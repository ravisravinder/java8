package java8.streams;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://medium.com/@mrinalgupta/asking-chatgpt-to-teach-me-java-streams-api-763492b6da71
public class StreamTesting {
    public static void main(String[] args) {

        List<Employee> employeesData = EmployeeDemo.getEmployeesData();

        //Get a list of active employees with salary grater then 50000

        List<Employee> activeEmpWithSalAbove5000 = employeesData.stream()
                .filter(Employee::isActive)
                .filter(employee -> employee.getSalary() > 50000)
                .collect(Collectors.toList());
        System.out.println(activeEmpWithSalAbove5000);

        //Get the total number of employees who posses Java and Python skills
        long count = employeesData.stream().filter(employee ->
                        employee.getSkills().contains("Java") &&
                                employee.getSkills().contains("Python"))
                .count();
        System.out.println("Number of employes with Java and Python skills: " + count);

        //Find the employee with the Highest Salary
        Optional<Employee> employeeWithHighestSalary = employeesData.stream().
                max(Comparator.comparingDouble(Employee::getSalary));
        employeeWithHighestSalary.ifPresent(employee -> System.out.println("Employee with highest salary: " + employee));

        //Group employees by their age
        Map<Integer, List<Employee>> employeesByAge =
                employeesData.stream()
                        .collect(Collectors.groupingBy(Employee::getAge));
        employeesByAge.forEach((age,empList)-> System.out.println("Employees with age "+age +": "+empList));


        //Calculate the avg salary of all employees
        double averageSalary = employeesData.stream()
                .mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.println("Averaage salary: "+averageSalary);

        //Find the employees with most number of skills
        Optional<Employee> mostSkilledEmployee = employeesData.stream()
                .max(Comparator.comparingInt(emp -> emp.getSkills().size()));
        mostSkilledEmployee.ifPresent(employee -> System.out.println("Employee with the most skills "+employee));

        //Calculate the total salary of active employees in each department
        Map<Object, Double> departmentSalarySum = employeesData.stream()
                .filter(Employee::isActive)
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        departmentSalarySum.forEach((department,totalSalary)->
                System.out.println("Total salary in "+department+" :"+totalSalary));


        //Find the employess who joined first in each department
        Map<Object, Optional<Employee>> earliestEmployeeByDept = employeesData.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.minBy(Comparator.comparing(Employee::getHireDate))));

        earliestEmployeeByDept.forEach((department,employee)->
                employee.ifPresent(emp-> System.out.println("Earliest joined employee in "+department+" :"+emp )));

        //Check if any employee has both a skill and a
        // contact detail containing keyword example

        boolean hasEmployeeWithSkillANdKeyword = employeesData.stream()
                .anyMatch(employee -> employee.getSkills()
                        .stream().anyMatch(
                skill -> employee.getContactInfo()
                        .values().stream().anyMatch(contact ->
                        contact.contains("example")))

                );

        System.out.println("Has employee with skill and keyword:"+hasEmployeeWithSkillANdKeyword);

// Problem: Sort employees based on their skills
// (lexicographically) and then by salary (descending)
        List<Employee> soretedEmployees = employeesData.stream()
                .sorted(Comparator.comparing(Employee::getSkills,
                                Comparator.comparing(List::toString))
                        .thenComparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        soretedEmployees.forEach(System.out::println);

        // Problem: Calculate the average age of employees in each department

        Map<String, Double> departmentAverageAge = employeesData.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(Employee::getAge)));

        departmentAverageAge.forEach((department, averageAge) ->
                System.out.println("Average age in " + department + ": " + averageAge));


// Problem: Find employees who have duplicate skills

        Map<List<String>, List<Employee>> employeesWithDuplicateSkills =
                employeesData.stream()
                .collect(Collectors.groupingBy(Employee::getSkills));

        employeesWithDuplicateSkills.values().stream()
                .filter(empList -> empList.size() > 1)
                .flatMap(List::stream)
                .distinct()
                .forEach(System.out::println);

// Problem: Calculate the total salary of employees for each year
// since their hire date

        Map<Integer, Double> yearlySalarySum = employeesData.stream()
                .collect(Collectors.groupingBy(emp -> getYear(emp.getHireDate()),
                        Collectors.summingDouble(Employee::getSalary)));

        yearlySalarySum.forEach((year, totalSalary) ->
                System.out.println("Total salary in year " + year + ": " + totalSalary));


// Problem: Split employees into two groups based on their
// salary (above and below average)

        double averageSalaryValue = employeesData.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        Map<Boolean, List<Employee>> employeesBySalaryGroup = employeesData.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > averageSalaryValue));

        List<Employee> aboveAverageSalary = employeesBySalaryGroup.get(true);
        List<Employee> belowAverageSalary = employeesBySalaryGroup.get(false);

        System.out.println("Employees with salary above average: " + aboveAverageSalary);
        System.out.println("Employees with salary below average: " + belowAverageSalary);


// Problem: Increase the salary of employees with active status by 10% and decrease the salary of inactive employees by 5%

        List<Employee> updatedEmployees = employeesData.stream()
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

        int totalYearsOfExperience = employeesData.stream()
                .mapToInt(emp -> getYear(new Date()) - getYear(emp.getHireDate()))
                .sum();

        System.out.println("Total years of experience: " + totalYearsOfExperience);


// Problem: Calculate the cumulative years of experience for all employees

        int totalYearsOfExperienceValue = employeesData.stream()
                .mapToInt(emp -> getYear(new Date()) - getYear(emp.getHireDate()))
                .sum();

        System.out.println("Total years of experience: " + totalYearsOfExperienceValue);

// Problem: Find the department with the highest average salary

        Optional<Map.Entry<String, Double>> departmentWithHighestAvgSalary = employeesData.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        departmentWithHighestAvgSalary.ifPresent(department ->
                System.out.println("Department with highest average salary: " + department.getKey()));


// Problem: Get the top three employees with the most diverse (unique) skills

        List<Employee> topThreeDiverseEmployees = employeesData.stream()
                .sorted(Comparator.comparingInt(emp -> emp.getSkills().size()))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top three employees with the most diverse skills: " + topThreeDiverseEmployees);



// Problem: Calculate the accumulated total salary of employees in each department over time

        Map<String, List<Double>> departmentAccumulatedSalary = employeesData.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getSalary,
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

        Map<String, Optional<Employee>> employeeWithMostSkillsByDept = employeesData.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(emp -> emp.getSkills().size()))));

        employeeWithMostSkillsByDept.forEach((department, employee) ->
                employee.ifPresent(emp -> System.out.println("Employee with the most skills in " + department + ": " + emp)));


// Problem: Partition employees into two groups based on their total years of experience (over and under 5 years)

        Map<Boolean, List<Employee>> employeesByExperience = employeesData.stream()
                .collect(Collectors.partitioningBy(emp -> getTotalYearsOfExperience(emp) >= 5));

        List<Employee> experiencedEmployees = employeesByExperience.get(true);
        List<Employee> inexperiencedEmployees = employeesByExperience.get(false);

        System.out.println("Experienced employees (5+ years of experience): " + experiencedEmployees);
        System.out.println("Inexperienced employees (less than 5 years of experience): " + inexperiencedEmployees);



        // Problem: Find the departments with at least one active employee
        Set<String> activeDepartments = employeesData.stream()
                .filter(Employee::isActive)
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());

        System.out.println("Departments with at least one active employee: " + activeDepartments);

        // Problem: Create a list of employees with an additional skill "Java 8"
        List<Employee> employeesWithJava8Skill = employeesData.stream()
                .map(emp -> {
                    List<String> updatedSkills = new ArrayList<>(emp.getSkills());
                    updatedSkills.add("Java 8");
                    return new Employee(emp.getName(), emp.getDepartment(), emp.getAge(),
                            emp.getSalary(), updatedSkills, emp.getContactInfo(), emp.getHireDate(), emp.isActive());
                })
                .collect(Collectors.toList());

        System.out.println("Employees with an additional skill 'Java 8': " + employeesWithJava8Skill);

        // Problem: Find the employee with the longest name
        Optional<Employee> employeeWithLongestName = employeesData.stream()
                .max(Comparator.comparingInt(emp -> emp.getName().length()));

        employeeWithLongestName.ifPresent(emp ->
                System.out.println("Employee with the longest name: " + emp));

        // Problem: Calculate the factorial of the sum of ages of all employees
        int sumOfAges = employeesData.stream()
                .mapToInt(Employee::getAge)
                .sum();

        long factorial = IntStream.rangeClosed(1, sumOfAges)
                .reduce(1, (acc, i) -> acc * i);

        System.out.println("Factorial of the sum of ages: " + factorial);

        // Problem: Check if all employees have a valid email address
        boolean allEmployeesHaveValidEmail = employeesData.stream()
                .allMatch(emp -> isValidEmail(emp.getContactInfo().get("Email")));

        System.out.println("All employees have valid email addresses: " + allEmployeesHaveValidEmail);
        StreamTesting streamTesting = new StreamTesting();
        Map<String, Double> topThreeDepartmentsByAvgSalary = streamTesting.getTopThreeDepartmentsByAvgSalary(employeesData);

        // Problem: Get the top 3 departments with the highest average salary
      /*  Map<String, Double> topThreeDepartmentsByAvgSalary = employeesData.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue).reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));*/

        System.out.println("Top 3 departments with the highest average salary: " + topThreeDepartmentsByAvgSalary);
    }

    private Map<String, Double> getTopThreeDepartmentsByAvgSalary(List<Employee> employeesData) {
        return employeesData.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }
    private static int getTotalYearsOfExperience(Employee employee) {
        Date hireDate = employee.getHireDate();
        LocalDate currentDate = LocalDate.now();
        LocalDate hireLocalDate = hireDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return Period.between(hireLocalDate, currentDate).getYears();
    }

    private static int getYear(Date date) {
        // Use Calendar to get the year
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);

}

    private static boolean isValidEmail(String email) {
        // Simplified email validation logic
        return email != null && email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
}
