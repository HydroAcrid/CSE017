//package ProgramProject1;

abstract class Titles implements Comparable<Titles>, Restorable {

    private String callNum;
    private String title;
    private String publisher;
    private int copies = 0;
    private int pubDate = 0;

    public Titles() {
        //no-arg constructor
    }

    public Titles(String callNum, String title, String publisher, int pubDate, int copies) {
        this.callNum = callNum;
        this.title = title;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.copies = copies;
    }

    public String getCallNum() {
        return callNum;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPubDate() {
        return pubDate;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPubDate(int pubDate) {
        this.pubDate = pubDate;
    }

    public String toString() {
        return String.format("%-16s%-56s%-28s%-10s%s", callNum, title, publisher, pubDate, copies);
    }

    public String simpleString() {
        return String.format("%s\n%s\n%s\n%s\n%s", callNum, title, publisher, pubDate, copies);
    }

    public int compareTo(Titles literature) {
        if(this.getPubDate() == literature.getPubDate()) {
            return 0;
        }
        else if(this.getPubDate() > literature.getPubDate()) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public void isRestorable(Titles literature) {

    }




    




    
}
