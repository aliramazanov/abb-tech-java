package lesson02;

public class CalculatorImplementation implements CalculatorService {
    
    @Override
    public int doCalculation (int a, int b, String method) {
       
        return switch (method) {
            case "add" -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            case "divide" -> a / b;
            
            default -> throw new IllegalArgumentException("Invalid method: " + method);
        };
    }
}