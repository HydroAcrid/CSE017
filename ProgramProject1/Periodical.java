//package ProgramProject1;

public class Periodical extends Titles {
    
    private int month;
    private int issueNum;

    public Periodical() {
        super();
        month = 0;
        issueNum = 0;
    }

    public Periodical(String callNum, String title, String publisher, int pubDate, int copies, int month, int issueNum) {
        super(callNum, title, publisher, pubDate, copies);
        this.month = month;
        this.issueNum = issueNum;
    }
    
    public int getMonth() {
        return month;
    }

    public int issueNum() {
        return issueNum;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }

    // public int compareTo(Periodical literature) {
    //     return this.getPubDate() - literature.getPubDate();
    // }

    public void isRestorable() {

    }

    public String toString() {
        return String.format("%s          %-20s     %s", super.toString(), month, issueNum);
    }

    public String simpleString() {
        return String.format("%s\n%s\n%s", super.simpleString(), month, issueNum);
    }
}
