import java.util.Arrays;

public class TwoDimensionalArray {
    
    static void main () {
        
        short[][] a = new short[3][3];
        
        short[][] b = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 9, 9 }
        };
        
        int[] numbers = new int[5];
        
        Float[] floats = new Float[5];
        floats = new Float[] { 10.4f, 12.3f, 45.8f };
        
        Float[] digits = new Float[5];
        
        for (int i = 0; i < digits.length; i++) {
            digits[i] = i * 5.5f;
        }
        
        for (Float digit : digits) {
            IO.println("digit: " + digit);
        }
        
        double[] prices = { 10, 55, 87, 95, 100 };
        
        for (int i = 0; i < prices.length; i++) {
            IO.println("prices[i]: " + prices[i]);
        }
        
        for (Float oneFloat : floats) {
            IO.println("oneFloat: " + oneFloat);
        }
        
        for (int i = 0; i < numbers.length; i++) {
            IO.println("numbers[i]: " + numbers[i]);
        }
        
        int[][] dimensions = new int[5][5];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < dimensions[i].length; j++) {
                dimensions[i][j] = j * (i + 2);
            }
        }
        
        for (int i = 0; i < dimensions[0].length; i++) {
            IO.println("dimensions[0][" + i + "]: " + dimensions[0][i]);
            
            for (int j = 0; j < dimensions[1].length; j++) {
                IO.println("dimensions[1][" + j + "]: " + dimensions[1][j]);
            }
        }
        
        int[][][] threeDimensionalArray = {
                {
                        { 1, 2, 3 },
                        { 1, 2, 3 },
                        { 1, 2, 3 }
                },
                {
                        { 3, 2, 1 },
                        { 3, 2, 1 },
                        { 3, 2, 1 },
                        },
                {
                        { 4, 5, 6 },
                        { 4, 5, 6 },
                        { 4, 5, 6 },
                        },
                {
                        { 6, 5, 4 },
                        { 6, 5, 4 },
                        { 6, 5, 4 },
                        },
                {
                        { 7, 8, 9 },
                        { 7, 8, 9 },
                        { 7, 8, 9 },
                        },
                {
                        { 9, 8, 7 },
                        { 9, 8, 7 },
                        { 9, 8, 7 },
                        }
        };
        
        for (int i = 0; i < threeDimensionalArray.length; i++) {
           
            for (int j = 0; j < threeDimensionalArray[i].length; j++) {
              
                for (int k = 0; k < threeDimensionalArray[i][j].length; k++) {
                   
                    IO.println("threeDimensionalArray[" + i + "][" + j + "][" + k + "]: " + threeDimensionalArray[i][j][k]);
                }
            }
        }
        
    }
}
