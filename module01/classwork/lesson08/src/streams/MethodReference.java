package streams;

import java.util.List;

public class MethodReference {
    
    public static double calculateArea (Integer radius) {
        return Math.PI * radius * radius;
    }
    
    public static void printArea (Integer radius) {
        double area = calculateArea(radius);
        System.out.println("Radius: " + radius + " -> Area: " + area);
    }
    
    static void main () {
        List<Integer> numbers = List.of(10, 2, 3, 4, 5);
        
        System.out.println("Lambda: ");
        numbers.stream().forEach(number -> printArea(number));
        
        System.out.println("Method Reference: ");
        numbers.stream().forEach(MethodReference::printArea);
    }
}