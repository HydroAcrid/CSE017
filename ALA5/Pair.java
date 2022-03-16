
//you can get this one the slides 
    
public class Pair<E1, E2> {
        private E1 first;
        private E2 second;

        public Pair(){
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

        public void setFirst(E1 f) {
            first = f;
        }

        public void setSecond(E2 s) {
            second = s;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        public boolean equals(Object obj) {
            if(obj instanceof Pair) {
                Pair<E1, E2> p =(Pair) obj;
                boolean f = this.first.equals(p.first);
                boolean s = this.second.equals(p.second);
                return f && s;
            }
            return false;
        }


    }

