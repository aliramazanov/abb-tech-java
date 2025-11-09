import java.util.List;

@SuppressWarnings("Convert2MethodRef")
public class ASCII {
    
     static void main() {
        
        List<String> strings = List.of("A", "E", "F", "C", "R", "Z");
        
        int sumOfCharNumbers = strings.stream()
                .map(s -> (int) s.charAt(0))
                .reduce(0, (a, b) -> a + b);
        
        System.out.println(sumOfCharNumbers);
    }
}