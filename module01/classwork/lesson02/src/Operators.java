public class Operators {
    static void main (String[] args) {
        
        int x = 10;
        x++;
        x--;
        ++x;
        x++;
        
        IO.println(x);
        IO.println(x++);
        IO.println(++x);
        
        int y = 5;
        y = x << y;
        IO.println(y);
        
        // Expression, && ||, Ternary
        
        int height = 20;
        int width = 10;
        int area = height * width;
        IO.println(area);
        
        int length = 15;
        int volume = height * width * length;
        IO.println(volume);
        
        int result = height > width ? width : height;
        IO.println(result);
       
        length = length > width ? length - 8 : length + 10;
        IO.println(length);
        
        boolean test = true;
        IO.println(!test && width > 5 || height > 10);
    }
}
