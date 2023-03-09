package cz.czechitas.ukol3.model;

public class Ram {

    private final long capacity;

    public Ram(long capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return String.format("%d GB RAM", capacity);
    }
}
