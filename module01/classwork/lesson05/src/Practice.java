import java.util.Scanner;

public class Practice {
    
    static void main () {
        OverloadMethods overload = new OverloadMethods();
        overload.drive();
        overload.drive(10, "Toyota");
        overload.drive("Toyota");
        
        Calculator calculator = new Calculator();
        float resultOne = calculator.add(4.3f, 2.50987f);
        double resultTwo = calculator.multiply(4.4, 5.6);
        
        int resultThree = calculator.add(3, 4);
        float resultFour = calculator.multiply(3.2344f, 8.543f);
        
        System.out.println(resultOne + resultTwo + resultThree + resultFour);
        
        System.out.println(Week.SUNDAY);
        System.out.println(Week.MONDAY.ordinal());
        System.out.println(Week.MONDAY.getIdx());
        System.out.println(Week.MONDAY.getTranslation_AZE());
        System.out.println(Week.MONDAY.isEndOfWeek());
        System.out.println(Week.SUNDAY.isEndOfWeek());
        
        System.out.println(Months.AUGUST);
        System.out.println(Months.AUGUST.getHowManyDays());
        
        
        Scanner scanner = new Scanner(System.in);
        int selectedDay;
        
        System.out.println("Enter day of the week in number: ");
        
        selectedDay = scanner.nextInt();
        Week day = Week.getDayByIndex(selectedDay);
        
        switch (day) {
            case MONDAY -> System.out.println("Monday");
            case TUESDAY -> System.out.println("Tuesday");
            case WEDNESDAY -> System.out.println("Wednesday");
            case THURSDAY -> System.out.println("Thursday");
            case FRIDAY -> System.out.println("Friday");
            case SATURDAY -> System.out.println("Saturday");
            case SUNDAY -> System.out.println("Sunday");
        }
    }
}
