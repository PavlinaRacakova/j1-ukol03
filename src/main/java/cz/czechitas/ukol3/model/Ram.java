package cz.czechitas.ukol3.model;

public class Ram {

    private long capacity;

    public Ram(long capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return String.format("%d GB RAM", capacity);
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }
}
