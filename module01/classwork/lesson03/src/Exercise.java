import java.util.Scanner;

public class Exercise {
    
    static void main () {
        Scanner scanner = new Scanner(System.in);
        
        String inputWord;
        System.out.println("Enter a word for selecting the index: ");
        inputWord = scanner.nextLine();
        
        int selectedIndex;
        System.out.println("Enter the symbol for getting the index: ");
        selectedIndex = scanner.nextInt();
        
        if (inputWord.length() < selectedIndex){
            System.out.println("Please select an index in bounds of length of the word");
        }
        
        char selectedSymbol;
        selectedSymbol = inputWord.charAt(selectedIndex);
        
        System.out.println(selectedSymbol);
        
        scanner.close();
    }
}
