package task03;
import java.util.Scanner;

public class ReverseNumber {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter array length: ");
        int size = scanner.nextInt();
        
        int[] arrayOfNumbers = new int[size];
        
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arrayOfNumbers[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < arrayOfNumbers.length; i++) {
           
            for (int j = 0; j < arrayOfNumbers.length; j++) {
           
                if (arrayOfNumbers[i] < arrayOfNumbers[j]) {
                    int small = arrayOfNumbers[i];
                    int big = arrayOfNumbers[j];
                    
                    arrayOfNumbers[i] = big;
                    arrayOfNumbers[j] = small;
                }
            }
        }
        
        for (int k : arrayOfNumbers) {
            System.out.print(k + " ");
        }
        
        scanner.close();
    }
}