import java.io.Serial;
import java.io.Serializable;

@SuppressWarnings("ClassCanBeRecord")
public class User implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    private final String username;
    private final String email;
    private final int age;
    
    public User (String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    @Override
    public String toString () {
        return "User{" +
               "username='" + username + '\'' +
               ", email='" + email + '\'' +
               ", age=" + age +
               '}';
    }
}
