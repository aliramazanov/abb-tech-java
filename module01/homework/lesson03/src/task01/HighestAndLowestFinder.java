package task01;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class HighestAndLowestFinder {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        String inputList;
        
        System.out.println("You are going to enter a random list of numbers\n ");
        System.out.println("The application will find out the lowest and the highest number\n ");
        System.out.println("Please use a (comma symbol: , ) between all numbers to make it work\n");
        System.out.println("Best use case: 1, 2, 3, 99, 456, 95\n");
        System.out.print("Input please: ");
        
        inputList = scanner.nextLine();
        String[] inputToArray = inputList.split(",");
        // System.out.println(Arrays.toString(inputToArray));
        int[] integers = new int[inputToArray.length];
        
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(inputToArray[i].trim());
        }
        
        int biggest = integers[0];
        int smallest = integers[0];
        
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] > biggest) {
                biggest = integers[i];
            }
            if (integers[i] < smallest) {
                smallest = integers[i];
            }
        }
        
        System.out.println("Your biggest number: " + biggest);
        System.out.println("Your smallest number: " + smallest);
        
        scanner.close();
    }
}
