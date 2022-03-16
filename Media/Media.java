package Media;
public class Media {

    private String title;
    private String genre;
    private String rating;

    public Media(){
        //no arg constructor
    }

    public Media(String title, String genre, String rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String toString() {
        //return String.format("Title: %s\n Genre: %s\n Rating: %s\n", title, genre, rating);
        // System.out.printf("%-30s\t%-10s\t%-5s\t%s\n",
        //   "Title", "Genre", "Rating", "Duration/Seasons");

        return String.format("%-30s\t%-10s\t%-5s", title, genre, rating);
    }


    
}
