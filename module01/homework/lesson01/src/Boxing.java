public class Boxing {
    static void main () {
        
        int primitiveValue = 12;
        Integer wrappedValue = primitiveValue;
        
        IO.println(primitiveValue);
        IO.println(wrappedValue);
        
        Integer newWrapped = 100;
        int newPrimitive = newWrapped;
        
        IO.println(newWrapped);
        IO.println(newPrimitive);
        
        IO.println(newWrapped.doubleValue());
        // doubleValue doesn't exist on primitive
        // Cannot call methods on 'int' type
        // IO.println(primitiveValue.doubleValue());
    }
}
