package objects;

public class Practice {
    
    static void main () {
       
        Employee employeeOne = new Employee("Employee", "One", 7000.0, 28);
        Employee employeeOneClone = new Employee("Employee", "One", 7000.0, 28);
        
        System.out.println("\n" + employeeOne.equals(employeeOneClone) + "\n");
        
        System.out.println(employeeOne.hashCode());
        System.out.println(employeeOneClone.hashCode() + "\n");
        
        
        System.out.println(employeeOne);
        System.out.println(employeeOneClone);
    }
}
