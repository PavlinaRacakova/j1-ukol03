package cz.czechitas.ukol3.model;

public class HardDrive {

    private final long capacity;
    private long usedSpace;

    public HardDrive(long capacity) {
        this.capacity = capacity;
        usedSpace = 0L;
    }

    @Override
    public String toString() {
        return String.format("%d GB hard drive", capacity);
    }

    public boolean addFile(long fileSize) {
        if (capacity >= usedSpace + fileSize) {
            usedSpace += fileSize;
            return true;
        }
        return false;
    }

    public boolean deleteFile(long fileSize) {
        if (usedSpace - fileSize >= 0) {
            usedSpace -= fileSize;
            return true;
        }
        return false;
    }

    public long getCapacity() {
        return capacity;
    }

    public long getUsedSpace() {
        return usedSpace;
    }
}
