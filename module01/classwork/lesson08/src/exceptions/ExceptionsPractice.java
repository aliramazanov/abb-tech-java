package exceptions;
import java.sql.SQLException;

@SuppressWarnings({ "ExplicitToImplicitClassMigration", "RedundantSuppression" })
public class ExceptionsPractice {
    
    static void main () {
       
        Frog frog = new Frog("exceptions.Frog", 3);
        frog.jumpNormal();
      
        tryToJump(frog);
        
        try (Frog frog1 = new Frog("exceptions.Frog", 3)) {
            frog1.jump();
        }
    }
    
    public static void tryToJump (Frog frog) {
       
        try {
            frog.jumpAgain();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
