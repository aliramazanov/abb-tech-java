public class MixedPractice {
    
    static int someNumber () {
        return 1;
    }
    
    void main () {
        double result = doCalculation(10, 15);
        double otherResult = doCalculation(18, 10);
        int test = someNumber();
        
        System.out.println(result + " " + otherResult);
        System.out.println(test);
    }
    
    final double doCalculation (double first, double second) {
        return first * second;
    }
}
