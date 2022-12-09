public class Pair <E1, E2>{
    private E1 first;
    private E2 second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(E1 first, E2 second) {
        this.first = first;
        this.second = second;
    }

    public E1 getFirst() {
        return first;
    }

    public E2 getSecond() {
        return second;
    }

    public void setFirst(E1 first) {
        this.first = first;
    }

    public void setSecond(E2 second) {
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public boolean equals(Object obj) {
        if(obj instanceof Pair<?, ?>) {
            Pair<E1, E2> p = (Pair<E1, E2>) obj;
            boolean r1 = first.equals(p.first);
            boolean r2 = second.equals(p.second);
            return (r1 && r2);
        }
        return false;
    }
}
