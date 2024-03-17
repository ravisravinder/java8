package java8.streams;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Employee {
    private String name;

    private String department;
    private int age;
    private double salary;
    private List<String> skills;
    private Map<String, String> contactInfo;
    private Date hireDate;
    private boolean isActive;

    public Employee(){}



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<String, String> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Map<String, String> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", skills=" + skills +
                ", contactInfo=" + contactInfo +
                ", hireDate=" + hireDate +
                ", isActive=" + isActive +
                '}';
    }

    public Employee(String name, String department, int age, double salary, List<String> skills, Map<String, String> contactInfo, Date hireDate, boolean isActive) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.skills = skills;
        this.contactInfo = contactInfo;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }
}
