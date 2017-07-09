import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Stock {
    //Attributes
    private Map<Part, Integer> parts = new HashMap<>();
    //private List<Observation> observers = new ArrayList<>();
    private Observation observers;



    //Methods
    public int get(Part part) throws NullPointerException {
        if(part == null) throw new NullPointerException();
        if(this.parts.containsKey(part)) {
            return this.parts.get(part);
        } else {
            return -1;
        }
    }
    public boolean set(Part part, int count)throws NullPointerException {
        if(part == null) throw new NullPointerException();
        if(count < 0 || !this.parts.containsKey(part)) {
            return false;
        } else {
            this.parts.replace(part, count);
            return true;
        }
    }
    public void insert(Part part, int count)throws NullPointerException, IllegalArgumentException {
        if(part == null) throw new NullPointerException();
        if(count < 1) throw new IllegalArgumentException();
        if(this.parts.containsKey(part)) {
            this.parts.replace(part, this.parts.get(part)+count);
        } else {
            this.parts.put(part, count);
        }



    }
    public boolean delete(Part part, int count) throws NullPointerException {
        if(part == null) throw new NullPointerException();
        if(count < 0) return false;
        if(this.parts.containsKey(part)) {
            if(this.parts.get(part) - count > 0) {
                this.parts.replace(part, this.parts.get(part) - count);
                if(get(part) < 10) {
                    notify(part);
                }
                return true;
            } else {
                return false;
            }
        }
        return false;


    }
    public void register(Observation observation) throws NullPointerException {
        if(observation == null) throw new NullPointerException();
        this.observers = observation;


    }
    public void notify(Part part) throws NullPointerException {
        if(part == null) throw new NullPointerException();
        observers.alarm(part);


    }
}
