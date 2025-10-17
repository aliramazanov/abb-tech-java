public class StringPractice {
    
    static void main () {
        
        String courseName = "Tech Academy";
        String courseNameAnother = new String("Tech Academy");
        String courseNameOneMore = String.valueOf("Tech Academy");
        String testCourse = new String("Tech Academy");
        
        IO.println(System.identityHashCode(courseName));
        IO.println(System.identityHashCode(courseNameAnother));
        IO.println(System.identityHashCode(courseNameOneMore));
        IO.println(System.identityHashCode(testCourse));
    }
}
