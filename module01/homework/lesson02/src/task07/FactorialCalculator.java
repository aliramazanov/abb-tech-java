package task07;

import java.util.Scanner;

public class FactorialCalculator {
    
     static void main() {
       
        Scanner scanner = new Scanner(System.in);
        
        IO.println("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt();
        
        if (number < 0) {
            IO.println("Factorial can't be calculated for negative numbers");
        } else {
            int factorial = 1;
            
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            
            IO.println("Factorial of " + number + " is: " + factorial);
        }
        
        scanner.close();
    }
}