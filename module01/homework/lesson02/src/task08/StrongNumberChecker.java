package task08;
import java.util.Scanner;

public class StrongNumberChecker {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        IO.println("Enter a number: ");
        int number = scanner.nextInt();
        
        int original = number;
        int sum = 0;
        
        while (number > 0) {
            int digit = number % 10;
            int factorial = 1;
            
            for (int i = 1; i <= digit; i++) {
                factorial *= i;
            }
            
            sum += factorial;
            number /= 10;
        }
        
        IO.println(sum == original ? "Strong number" : "Not a strong number");
        
        scanner.close();
    }
}