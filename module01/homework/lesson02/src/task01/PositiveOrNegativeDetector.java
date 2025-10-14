package task01;
import java.util.Scanner;

public class PositiveOrNegativeDetector {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        IO.println("Please enter a number: ");
        String userInput = scanner.next();
        double number = Double.parseDouble(userInput);
        
        if (number > 0) { IO.println("The number you entered is positive"); }
        else if (number < 0) { IO.println("The number you entered is negative"); }
        else { IO.println("The number you entered is zero"); }
        
        scanner.close();
    }
}