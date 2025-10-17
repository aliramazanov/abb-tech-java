import java.math.BigDecimal;

public class ArraysPractice {
    
    static void main () {
        
        BigDecimal[] salaries = new BigDecimal[10];
        double[] percentages = { 1, 3, 5, 7 };
        int[] ages = new int[]{ 1, 3, 5, 7 };
        
        IO.println(salaries[0]);
        IO.println(percentages[0]);
        IO.println(ages[0]);
        
        IO.println(salaries.length);
        
        for (double percentage : percentages) {
            IO.println(percentage);
        }
    }
}
