//package java8.streams;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public class StreamTesting1 {
//    public static void main(String[] args) {
//        List<Employee> employees  = EmployeeDemo.getEmployeesData();
//
//        //get the list of active employees with salary grate than 5000
//
//        List<Employee> collect = employees.stream()
//                .filter(Employee::isActive)
//                .filter(e -> e.getSalary() > 50000)
//                .collect(Collectors.toList());
//        System.out.println("active employees with salary grate than 5000 "+collect);
//
//        //Get the total number of employees who posses Java and Python skills
//
//        long count = employees.stream().filter(e -> e.getSkills().contains("Java")
//                && e.getSkills().contains("Python")).count();
//
//        //Find the employee with the Highest Salary
//        Optional<Employee> employeeWithHighestSalary = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
//        employeeWithHighestSalary.ifPresent(employee -> System.out.println("Employee with highest salary: " + employee));
//
//        //Group employees by their age
//        Map<Integer,List<Employee>> employeeByAge = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getAge));
//
//        //Calculate the avg salary of all employees
//        employees.stream().mapToDouble(Employee::getSalary)
//                .average().orElse(0.00);
//        employees.stream().max(Comparator.comparingInt(e->e.getSkills().size()))
//
//        //Calculate the total salary of active employees in each department
//        employees.stream()
//                .filter(Employee::isActive)
//                .collect(Collectors.groupingBy
//                        (Employee::getDepartment,Collectors.summingDouble(Employee::getSalary));
//
//
//        //Find the employess who joined first in each department
//
//    }
//
//}
