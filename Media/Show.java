package Media;
public class Show extends Media {

    private int seasons;

    public Show() {
        super();
        seasons = 0;
    }

    public Show(String title, String genre, String rating, int seasons) {
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
    
}
