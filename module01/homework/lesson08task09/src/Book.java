public class Book {
   
    private String title;
    private String author;
    
    public int getYear () {
        return year;
    }
    
    public double getRating () {
        return rating;
    }
    
    private int year;
    private double rating;
    
    public boolean isAvailable () {
        return this.isAvailable;
    }
    
    private boolean isAvailable;
    
    public Book (
            String title,
            String author,
            int year,
            double rating,
            boolean isAvailable
    ) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }
    
    @Override
    public String toString () {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", year=" + year +
               ", rating=" + rating +
               ", isAvailable=" + isAvailable +
               '}';
    }
    
    public String getTitle () {
        return this.title;
    }
    
    public String getAuthor() {
        return author;
    }
}
