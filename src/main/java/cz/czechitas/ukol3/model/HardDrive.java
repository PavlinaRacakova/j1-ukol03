package cz.czechitas.ukol3.model;

public class HardDrive {

    private long capacity;
    private long usedSpace;

    public HardDrive (long capacity) {
        this.capacity = capacity;
        usedSpace = 0L;
    }

    @Override
    public String toString() {
        return String.format("%l GB hard drive", capacity);
    }
}
