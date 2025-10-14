package task04;
import java.util.Scanner;

public class PalindromeChecker {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        int input;
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        
        IO.println("Enter your palindrome number: ");
        input = scanner.nextInt();
        
        int original = input;
        int reversed = 0;
        
        while (input != 0) {
            int digit = input % 10;
            reversed = reversed * 10 + digit;
            input = input / 10;
        }
        
        if (original == reversed) { IO.println("It is a palindrome"); }
        
        input = original;
        int previousDigit = input % 10;
        input = input / 10;
        
        while (input != 0) {
            int currentDigit = input % 10;
            
            if (currentDigit > previousDigit) isIncreasing = false;
            if (currentDigit < previousDigit) isDecreasing = false;
            
            previousDigit = currentDigit;
            input = input / 10;
        }
        
        if (isIncreasing) { IO.println("The digits of the number are in increasing order"); }
        else if (isDecreasing) { IO.println("The digits of the number are in decreasing order"); }
        else { IO.println("The digits are neither in increasing nor decreasing order"); }
        
        scanner.close();
    }
}