public class Pair<E1, E2>{
    private E1 first;
    private E2 second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(E1 f, E2 s){
        first = f;
        second = s;
    }

    public E1 getFirst(){
        return first;
    }

    public E2 getSecond(){
        return second;
    }

    public void setFirst(E1 e){
        first = e;
    }

    public void setSecond(E2 e){
        second = e;
    }

    public boolean equals(Object obj){
        Pair<E1, E2> pair = (Pair<E1, E2>)obj;
        if(pair.getFirst() == pair.getSecond()){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return "(" + first + ", " + second + ")";
    }
}