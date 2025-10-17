package task02;
import java.util.Scanner;

public class MatrixSum {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        int[][][] list = {
                { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 10 } },
                { { 2, 4, 60 }, { 8, 10, 1 }, { 14, 16, 19 } },
                { { 5, 10, 15 }, { 20, 25, 30 }, { 35, 40, 45 } }
        };
        
        System.out.println("There are pre-built matrices in application");
        System.out.println("You have three different choices, please choose one of them");
        System.out.print("Choose matrix 1-2-3: ");
        int choice = scanner.nextInt();
        
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice!");
            scanner.close();
            return;
        }
        
        int[][] matrix = list[choice - 1];
        
        System.out.println(" ");
        System.out.println("Selected matrix elements:");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        int main = 0;
        int helper = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            main += matrix[i][i];
            helper += matrix[i][matrix.length - 1 - i];
        }
        
        System.out.println(" ");
        System.out.println("Main sum: " + main);
        System.out.println("Helper sum: " + helper);
        
        scanner.close();
    }
}