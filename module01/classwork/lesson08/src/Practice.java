import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings({ "ExplicitToImplicitClassMigration", "RedundantSuppression" })
public class Practice {
    
    static void main () {
        
        Predicate<Integer> isOddOrEven = a -> a % 2 == 0;
        
        boolean resultOne = isOddOrEven.test(5);
        boolean resultTwo = isOddOrEven.test(4);
        
        System.out.println(resultOne);
        System.out.println(resultTwo);
        
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        
        int resultThree = sum.apply(2, 3);
        System.out.println(resultThree);
        
        
        List<Character> symbols = List.of('a', 'b', 'c', 'd');
        
        var asciiValuesWithTraditionalMapping = symbols.stream()
                .map(s -> new ASCIIValues(s))
                .collect(Collectors.toSet());
        
        var asciiValues = symbols.stream()
                .map(ASCIIValues::new)
                .collect(Collectors.toSet());
        
        System.out.println("Traditional mapping:");
        asciiValuesWithTraditionalMapping.forEach(System.out::println);
        
        System.out.println("Constructor reference:");
        asciiValues.forEach(System.out::println);
        
        List<String> names = List.of("Ali", "John", "Jane");
        List<Person> people = names.stream().map(Person::new).toList();
        
        Function<String, Person> creator1 = Person::new;
        Person p1 = creator1.apply("Ali");
    }
}
