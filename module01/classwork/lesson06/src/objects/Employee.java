package objects;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String surname;
    private final double salary;
    private final int age;
    
    public Employee (
            String name,
            String surname,
            double salary,
            int age
    ) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.age = age;
    }
    
    @Override
    public boolean equals (Object obj) {
        
        if (obj instanceof Employee clonedEmployee) {
            return (this.name.equals(clonedEmployee.name)) &&
                   (this.surname.equals(clonedEmployee.surname)) &&
                   (this.salary == clonedEmployee.salary) &&
                   (this.age == clonedEmployee.age);
        }
        
        return false;
    }
    
    @Override
    public String toString () {
        String format = "Employee: %s %s, age: %d, salary %.2f";
        return format.formatted(name, surname, age, salary);
    }
    
    @Override
    public int hashCode () {
        String format = "Employee: %s %s, age: %d, salary %.2f";
        return format.hashCode();
        // return Objects.hash(name,surname,age,salary);
    }
}