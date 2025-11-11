package exceptions;
import java.util.Arrays;

@SuppressWarnings({ "ExplicitToImplicitClassMigration", "RedundantSuppression" })
public class Exceptions {
    
    static void main () {
        
        try {
            int a = 10;
            System.out.println(a / 0);
            System.out.println("Program completed");
        }
        catch (ArithmeticException e) {
            String stackTrace = Arrays.toString(e.getStackTrace());
            System.out.println("Division by Zero - Not Allowed");
            System.out.println("Exception Message: " + e);
            System.out.println("Stack Trace: " + stackTrace);
        }
        catch (NameException e) {
            System.out.println(e.getCode() + e.getMessage());
            throw new NameException("Name cannot be null!", ErrorCodeEnum.NAME_NULL, e);
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Error - Null Value Present");
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Something Went Wrong");
        }
        finally {
            System.out.println("Transaction Closed");
        }
        
        System.out.println("After Try - Catch Block");
    }
}
