package cz.czechitas.ukol3.model;

public class HardDrive {

    private long capacity;
    private long usedSpace;

    public HardDrive(long capacity) {
        this.capacity = capacity;
        usedSpace = 0L;
    }

    @Override
    public String toString() {
        return String.format("%d GB hard drive", capacity);
    }

    public boolean isPossibleToAddFile(long fileSize) {
        return capacity >= usedSpace + fileSize;
    }

    public boolean isPossibleToDeleteFile(long fileSize) {
        return usedSpace - fileSize >= 0;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(long usedSpace) {
        this.usedSpace = usedSpace;
    }
}
