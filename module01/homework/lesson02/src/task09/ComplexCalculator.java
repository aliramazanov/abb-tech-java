package task09;
import java.util.Scanner;

public class ComplexCalculator {
    
    static void main() {
        
        Scanner scanner = new Scanner(System.in);
        
        IO.println("Please enter the number: ");
        int numberInput = scanner.nextInt();
        
        String num = "" + numberInput;
        int digitCount = num.length();
        
        int sum = 0;
        
        for (int i = 0; i < digitCount; i++) {
            int digit = num.charAt(i) - '0';
            int power = 1;
            
            for (int j = 0; j < digitCount; j++) {
                power = power * digit;
            }
            
            sum = sum + power;
        }
        
        IO.println("Power sum: " + sum);
        IO.println("Original: " + numberInput);
        IO.println("Are the numbers equals: " + (sum == numberInput));
        
        scanner.close();
    }
}