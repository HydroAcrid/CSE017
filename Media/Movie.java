package Media;
public class Movie extends Media {
    
    private int duration;

    public Movie() {
        super();
        duration = 0;
    }

    public Movie(String title, String genre, String rating, int duration) {
        super(title, genre, rating);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return String.format("%s\t  %s", super.toString(), duration);
    }



}
