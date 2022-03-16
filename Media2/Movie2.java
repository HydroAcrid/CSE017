package Media2;

public class Movie2 extends Media2 {

    private int duration;

    public Movie2() {
        super();
        duration = 0;
    }

    public Movie2(String title, String genre, String rating, int duration) {
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

    public String simpleString() {
        return String.format("%s|%d", super.simpleString(), duration);

    }
    
}
