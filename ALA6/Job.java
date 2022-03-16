public class Job implements Comparable<Job> {
    private int id;
    private int group;
    private long size;

    public Job(int id, int group, long size) {
        this.id = id;
        this.group = group;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public int getGroup() {
        return group;
    }

    public long getSize() {
        return size;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String toString() {
        double s = size;
        String unit = "B";
        if(s > 1000000000) {
            s /= 1000000000;
            unit = "GB";
        }
        else if(s > 1000000) {
            s /= 1000000;
            unit = "MB";
        }
        else if(s > 1000) {
            s /= 1000;
            unit = "KB";
        }
        return String.format("%-10d\t%-5d\t%-5.2f%s", id, group, s, unit);
    }

    public int compareTo(Job job) {
        return group - job.group;
    }

    
}
