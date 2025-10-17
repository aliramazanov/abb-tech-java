package task03;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class NumberBiggerThanSix {
    
    static void main () {
        
        int[][][] dimensions = {
                { { 1, 2 }, { 3, 4 } },
                { { 5, 6 }, { 7, 8 } }
        };
        
        boolean first = true;
        
        for (int i = 0; i < dimensions.length; i++) {
            
            for (int j = 0; j < dimensions[i].length; j++) {
                
                for (int k = 0; k < dimensions[i][j].length; k++) {
                    
                    if (dimensions[i][j][k] > 6) {
                        
                        if (!first) {
                            System.out.print(", ");
                        }
                        
                        System.out.print(dimensions[i][j][k]);
                        
                        first = false;
                    }
                }
            }
        }
    }
}
