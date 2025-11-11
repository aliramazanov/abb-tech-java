package exceptions;
import java.io.Serial;

public class NameException extends RuntimeException {
    
    @Serial
    private static final long serialVersionUID = 1L;
   
    private final String message;
    private final ErrorCodeEnum code;
    
    public NameException (String message, ErrorCodeEnum code, Throwable cause) {
        super(cause);
        this.message = message;
        this.code = code;
    }
    
    @Override
    public String getMessage () {
        return message;
    }
    
    public ErrorCodeEnum getCode () {
        return code;
    }
}
