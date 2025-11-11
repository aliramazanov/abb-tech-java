package exceptions;

import java.io.Closeable;
import java.sql.SQLException;

@SuppressWarnings("CommentedOutCode")
public class Frog extends Animal implements Closeable {
   
    private final String name;
    private final int age;
    
    public Frog (String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void jumpNormal () throws NameException {
       
        try {
            System.out.println(this.name + "exceptions.Frog is jumping");
        }
        catch (NameException nameException) {
            throw new NameException("Name not found", ErrorCodeEnum.NAME_NULL, nameException);
        }
    }
    
    // 'jump()' in 'exceptions.Frog' clashes with 'jump()' in 'exceptions.Animal'; overridden method does not throw 'java.sql.SQLException'
    
    /*
    public void jump () throws SQLException {
        try {
            System.out.println(this.name + "exceptions.Frog is jumping");
        }
        catch (exceptions.NameException nameException) {
            throw new exceptions.NameException("Name not found", exceptions.ErrorCodeEnum.NAME_NULL, nameException);
        }
    }
    */
    
    public void jumpAgain () throws SQLException {
        System.out.println(this.name + "exceptions.Frog is jumping");
    }
    
    public int getAge () {
        return age;
    }
    
    @Override
    public void close () {
        System.out.println("exceptions.Frog Obj Close");
    }
}
