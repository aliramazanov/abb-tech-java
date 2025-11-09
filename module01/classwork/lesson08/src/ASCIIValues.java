public class ASCIIValues {
    private final char character;
    private final int asciiValue;
    
    public ASCIIValues (char character) {
        this.character = character;
        this.asciiValue = character;
    }
    
    @Override
    public String toString() {
        return "ASCIIValues{" +
               "character=" + character +
               ", asciiValue=" + asciiValue +
               '}';
    }
}
