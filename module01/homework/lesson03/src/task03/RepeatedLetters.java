package task03;

import java.util.Scanner;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class RepeatedLetters {
    
     static void main() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter a sentence below");
        System.out.println("We will find how many times each letter is repeated");
        System.out.print("Input your sentence here: ");
        
        String input = scanner.nextLine().toLowerCase();
        String[] inputLetters = input.split("");
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[alphabet.length()];
        
        for (int i = 0; i < inputLetters.length; i++) {
            String letter = inputLetters[i];
            
            if (letter.matches("[a-z]")) {
                int position = alphabet.indexOf(letter);
                counts[position]++;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                System.out.println(alphabet.charAt(i) + " - " + counts[i]);
            }
        }
        
        scanner.close();
    }
}