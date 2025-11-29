package lesson02;

import java.util.Scanner;

public class Calculator {
    
    static void main () {
        
        int a, b;
        String method;
        
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Please enter first number: ");
        a = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Please enter second number: ");
        b = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Please enter the method -> add/subtract/multiply/divide: ");
        method = scanner.nextLine();
        
        CalculatorService calculatorService = new CalculatorImplementation();
        System.out.println("Result: " +  calculatorService.doCalculation(a, b, method));
    }
}
