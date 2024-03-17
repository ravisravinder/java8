package java8.streams;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeDemo {
    public static void main(String[] args) {
       // List<Employee> employees = new ArrayList<>();

        //create date format
        List<Employee> employeesData = getEmployeesData();
    }

    public static List<Employee> getEmployeesData() {
        List<Employee> employees = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            //create Employee objects
            Employee emp1 = new Employee("John Die", "DEV", 30, 50000.0,
                    Arrays.asList("Java", "Python", "SQL"),
                    getContactInfo("john.doe@example.com", "1234567890"),
                    dateFormat.parse("01/04/2020"), true);

            //create Employee objects
            Employee emp2 = new Employee("Alice smith", "DEV", 34, 60000.0,
                    Arrays.asList("JavaScript", "HTML", "CSS"),
                    getContactInfo("alice.smith@example.com", "9876543210"),
                    dateFormat.parse("12/01/2018"), true);

            //create Employee objects
            Employee emp3 = new Employee("Robert Johnson", "PROD", 28, 45000.0,
                    Arrays.asList("C++", "Python", "Data Analysis"),
                    getContactInfo("robert.johnson@example.com", "4567890123"),
                    dateFormat.parse("15/07/2019"), false);

            //create Employee objects
            Employee emp4 = new Employee("Emily Brown","PROD", 32, 55000.0,
                    Arrays.asList("Java", "JavaScript", "Angular"),
                    getContactInfo("emily.brown@example.com", "7890123456"),
                    dateFormat.parse("05/03/2017"), true);

            //create Employee objects
            Employee emp5 = new Employee("Michel Wilson","TEST", 29, 52000.0,
                    Arrays.asList("Python", "Machine Learning", "Big Data"),
                    getContactInfo("michel.wilson@example.com", "2345678901"),
                    dateFormat.parse("20/11/2018"), true);

            //create Employee objects
            Employee emp6 = new Employee("Olivia Davis","DEV", 31, 48000.0,
                    Arrays.asList("HTML", "CSS", "UI/UX Design"),
                    getContactInfo("olivia.davis@example.com", "6789012345"),
                    dateFormat.parse("02/09/2019"), true);

            //create Employee objects
            Employee emp7 = new Employee("James Miller","TEST", 33, 58000.0,
                    Arrays.asList("Java", "Spring Framework", "Hibernate"),
                    getContactInfo("james.miller@example.com", "8901234567"),
                    dateFormat.parse("14/06/2020"), true);

            //create Employee objects
            Employee emp8 = new Employee("Sophia Wilson","PROD", 27, 43000.0,
                    Arrays.asList("Python", "Data Science", "Data Visualization"),
                    getContactInfo("sophia.wilson@example.com", "4567890123"),
                    dateFormat.parse("23/02/2021"), true);

            //create Employee objects
            Employee emp9 = new Employee("Liam Anderson","TEST", 35, 62000.0,
                    Arrays.asList("Java", "Spring Boot", "Microservices"),
                    getContactInfo("liam.anderson@example.com", "67890122345"),
                    dateFormat.parse("17/10/2017"), true);

            //create Employee objects
            Employee emp10 = new Employee("Ava Lee","TEST", 28, 51000.0,
                    Arrays.asList("JavaScript", "React", "Node.js"),
                    getContactInfo("ava.lee@example.com", "9012345678"),
                    dateFormat.parse("29/12/2018"), true);

            //create Employee objects
            Employee emp11 = new Employee("Mason Harris","DEV", 30, 54000.0,
                    Arrays.asList("Python", "Machine Learning", "SQNatural Language Processing"),
                    getContactInfo("mason.harris@example.com", "3456789012"),
                    dateFormat.parse("16/08/2019"), true);

            //create Employee objects
            Employee emp12 = new Employee("Isabella Martinez","PROD", 29, 47000.0,
                    Arrays.asList("HTML", "CSS", "Bootstrap"),
                    getContactInfo("isabella.martinez@example.com", "7890123456"),
                    dateFormat.parse("25/05/2020"), true);

            //create Employee objects
            Employee emp13 = new Employee("William Wilson","TEST", 31, 60000.0,
                    Arrays.asList("Java", "Spring MVC", "RESTful APIs"),
                    getContactInfo("william.wilson@example.com", "1234567890"),
                    dateFormat.parse("03/05/2017"), true);

            //create Employee objects
            Employee emp14 = new Employee("Charlotte Davis","PROD",32, 52000.0,
                    Arrays.asList("Python", "Data Analysis", "SQL"),
                    getContactInfo("charlotte.davis@example.com", "5678901234"),
                    dateFormat.parse("22/11/2018"), true);

            //create Employee objects
            Employee emp15 = new Employee("Benjamin Taylor","TEST", 34, 58000.0,
                    Arrays.asList("JavaScript", "React Native", "Firebase"),
                    getContactInfo("benjamin.taylor@example.com", "9012345678"),
                    dateFormat.parse("11/07/2019"), true);

            employees.add(emp1);
            employees.add(emp2);
            employees.add(emp3);
            employees.add(emp4);
            employees.add(emp5);
            employees.add(emp6);
            employees.add(emp7);
            employees.add(emp8);
            employees.add(emp9);
            employees.add(emp10);
            employees.add(emp11);
            employees.add(emp12);
            employees.add(emp13);
            employees.add(emp14);
            employees.add(emp15);

          return employees;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, String> getContactInfo(String email, String phone) {
        Map<String, String> contactInfo = new HashMap<>();
        contactInfo.put("Email", email);
        contactInfo.put("Phone", phone);
        return contactInfo;
    }
}
