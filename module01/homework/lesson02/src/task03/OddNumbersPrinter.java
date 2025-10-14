package task03;
import java.util.Scanner;

public class OddNumbersPrinter {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        int userInput;
        IO.println("Please enter a number to see all odd numbers before it: ");
        userInput = scanner.nextInt();
        
        for (int i = 0; i < userInput ; i++) {
            if (i % 2 != 0){
                IO.println("The odd number: " + i);
            }
        }
        
        IO.println("End of the program");
        scanner.close();
    }
}
