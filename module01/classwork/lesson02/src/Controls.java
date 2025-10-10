import java.util.Scanner;

public class Controls {
    
    static void main () {
        
        Scanner scanner = new Scanner(System.in);
        
        int aInput;
        double bInput;
        String operator;

        IO.print("Enter a number: ");
        aInput = scanner.nextInt();

        IO.print("Enter b number: ");
        bInput = scanner.nextDouble();

        IO.println("Enter an operator + - * /");
        operator = scanner.next();

        IO.println("a * b = " + aInput * bInput);

        if (aInput == bInput) {
            IO.println("A input is same as B input");
        }

        if (aInput > bInput) {
            IO.println("A input is bigger than B input");
        }
        else {
            IO.println("B input is bigger than A input");
        }

        if (operator.equals("+")) {
            IO.println("Addition");
            IO.println("a + b: " + (aInput + bInput));
        }
        else if (operator.equals("-")) {
            IO.println("Deduction");
            IO.println("a - b: " + (aInput - bInput));
        }
        else if (operator.equals("*")) {
            IO.println("Multiplication");
            IO.println("a * b: " + (aInput * bInput));
        }
        else if (operator.equals("/")) {
            IO.println("Division");
            IO.println("a / b: " + (aInput / bInput));
        }
        else {
            IO.println("Wrong operator!");
        }

        switch (operator) {
            case "+" -> IO.println("\"Addition\" ->  " + (aInput + bInput));
            case "-" -> IO.println("\"Deduction\" -> " + (aInput - bInput));
            case "*" -> IO.println("\"Multiplication\" -> " + (aInput * bInput));
            case "/" -> IO.println("\"Division\" -> " + (aInput / bInput));
            default -> IO.println("Wrong operator!");
        }

        String selectedDay;
        IO.println("Enter a day of the week: ");
        scanner.nextLine();
        selectedDay = scanner.nextLine().toLowerCase();

        switch (selectedDay){
            case "monday" -> IO.println("You have selected Monday");
            case "tuesday" -> IO.println("You have selected Tuesday");
            case "wednesday" -> IO.println("You have selected Wednesday");
            case "thursday" -> IO.println("You have selected Thursday");
            case "friday" -> IO.println("You have selected Friday");
            case "saturday" -> IO.println("You have selected Saturday");
            case "sunday" -> IO.println("You have selected Sunday");
            default -> IO.println("You have selected wrong day!");
        }

        for (int i = 0, j = 0; i < 5 || j < 10; i++, j++) {
            IO.println(i);
            IO.println(j);
            IO.println("-------");
            IO.println(i + j);
            IO.println("-------");
        }
        
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                IO.println("Break outer loop on 5");
                break;
            }
            IO.println("Outer loop: " + i);
            
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    IO.println("Skipping 3 in inner loop");
                    continue;
                }
                IO.println("Inner loop: " + j);
            }
        }
        
        scanner.close();
    }
}

