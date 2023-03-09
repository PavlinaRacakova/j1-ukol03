package cz.czechitas.ukol3.model;

public class Computer {

    private boolean isTurnedOn;
    private Processor cpu;
    private Ram ram;
    private HardDrive hardDisk;

    public Computer(Processor cpu, Ram ram, HardDrive hardDisk) {
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        isTurnedOn = false;
    }

    public String toString() {
        return String.format("Computer parameters:\n%s\n%s\n%s\n", cpu, ram, hardDisk);
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOn() {
        if (isTurnedOn) {
            System.err.println("The computer is already turned on.");
        } else {
            System.out.println("The computer is turned on.");
            isTurnedOn = true;
        }
    }

    public void turnOff() {
        if (isTurnedOn) {
            System.out.println("The computer is turned off.");
            isTurnedOn = false;
        }
    }

    public void createFile(long size) {
        if (isTurnedOn) {
            if (hardDisk.addFile(size)) {
                System.out.printf("%d GB file added successfully.\n", size);
            } else {
                System.err.printf("%d GB file is too large.\n", size);
            }
        } else {
            System.err.println("Computer is turned off.");
        }
    }

    public void deleteFile(long size) {
        if (isTurnedOn) {
            if (hardDisk.deleteFile(size)) {
                System.out.printf("%d GB file has been deleted.\n", size);
            } else {
                System.err.printf("%d GB cannot be deleted.\n", size);
            }
        } else {
            System.err.println("Computer is turned off.");
        }
    }
}
