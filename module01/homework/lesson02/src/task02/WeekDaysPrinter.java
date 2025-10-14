package task02;
import java.util.Scanner;

public class WeekDaysPrinter {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        int selectedDay;
        IO.println("Please enter one number from 1 to 7 for choosing the weekday");
        selectedDay = scanner.nextInt();
        
        switch (selectedDay) {
            case 1 -> IO.println("Monday");
            case 2 -> IO.println("Tuesday");
            case 3 -> IO.println("Wednesday");
            case 4 -> IO.println("Thursday");
            case 5 -> IO.println("Friday");
            case 6 -> IO.println("Saturday");
            case 7 -> IO.println("Sunday");
            default -> IO.println("You have selected wrong day!");
        }
        
        scanner.close();
    }
}
