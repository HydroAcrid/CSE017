package Media2;
public class Show2 extends Media2{

    private int seasons;

    public Show2() {
        super();
        seasons = 0;
    }

    public Show2(String title, String genre, String rating, int seasons) {
        super(title, genre, rating);
        this.seasons = seasons;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public String toString() {
        return String.format("%s\t  %s", super.toString(), seasons);
    }

    public String simpleString() {
        return String.format("%s|%d", super.simpleString(), seasons);

    }
    
}
