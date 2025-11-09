import java.util.Optional;

@SuppressWarnings({ "ExplicitToImplicitClassMigration", "RedundantSuppression" })
public class Optionals {
    
    static void main () {
        
        Integer number = 10;
        Optional<Integer> optionalNumber = Optional.of(number);
        
        boolean isPresent = optionalNumber.isPresent();
        System.out.println("Present " + isPresent);
        
        Integer value1 = optionalNumber.orElse(0);
        System.out.println("Resul orElse: " + value1);
        
        Integer value2 = optionalNumber.orElseGet(() -> 0);
        System.out.println("Result orElseGet: " + value2);
        
        Integer value3 = optionalNumber.orElseThrow(() -> new RuntimeException("No value present"));
        System.out.println("Result orElseThrow: " + value3);
        
        optionalNumber.ifPresent(val -> System.out.println("Value is: " + val));
    }
}
