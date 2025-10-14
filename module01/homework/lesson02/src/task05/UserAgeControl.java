package task05;
import java.util.Scanner;

public class UserAgeControl {
    
     static void main() {
        Scanner scanner = new Scanner(System.in);
        
        IO.println("Please add your age: ");
        int userAge = scanner.nextInt();
        
        IO.println("Please type your gender M/F: ");
        String userGender = scanner.next().toLowerCase();
        
        if (!userGender.equals("m") && !userGender.equals("f")) {
            IO.println("Wrong input - Invalid gender entered");
        }
        else if (userAge < 18) {
            IO.println("Access Denied!");
        }
        else if (userGender.equals("m")) {
            IO.println("Male access granted");
        }
        else {
            IO.println("Female access granted");
        }
        
        scanner.close();
    }
}