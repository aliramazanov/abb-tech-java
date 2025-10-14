package task06;
import java.util.Scanner;

public class FibonacciPrinter {
    
     static void main() {
        Scanner scanner = new Scanner(System.in);
        
        int howManyNumbers;
        IO.println("Enter how many Fibonacci numbers you want to print: ");
        howManyNumbers = scanner.nextInt();
        
        if (howManyNumbers <= 0) {
            IO.println("Please enter a valid number");
        }
        else {
            int initial = 0;
            int next = 1;
            
            for (int i = 2; i < howManyNumbers; i++) {
                int current = initial + next;
              
                String evenOrOdd = (current % 2 == 0) ? "even" : "odd";
                IO.println(current + " - " + evenOrOdd);
                
                initial = next;
                next = current;
            }
        }
        
        scanner.close();
    }
}