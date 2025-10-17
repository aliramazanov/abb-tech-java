package task03;
import java.util.Scanner;

@SuppressWarnings("StringConcatenationInLoop")
public class ReverseString {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        
        String input = scanner.nextLine();
        String rev = reverse(input);
        
        System.out.println("Reverse: " + rev);
        
        scanner.close();
    }
    
    static String reverse (String input) {
        String reversed = "";
        
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        
        return reversed;
    }
}