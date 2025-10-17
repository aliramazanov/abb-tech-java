package task03;
import java.util.Scanner;

public class PalindromeCheck {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        
        String reversed = ReverseString.reverse(word);
        
        if (word.equals(reversed)) {
            System.out.println("Palindrome: " + word);
        }
        else {
            System.out.println("Not Palindrome: " + word);
        }
        
        scanner.close();
    }
}