package cz.czechitas.ukol3.model;

public class Computer {

    private boolean isTurnedOn;
    private Processor cpu;
    private Ram ram;
    private HardDrive hardDisk;
    private HardDrive secondDisk;

    //first constructor
    public Computer(Processor cpu, Ram ram, HardDrive hardDisk) {
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
    }

    //second constructor
    public Computer(Processor cpu, Ram ram, HardDrive hardDisk, HardDrive secondDisk) {
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.secondDisk = secondDisk;
    }

    public void setCpu(Processor cpu) {
        this.cpu = cpu;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setHardDisk(HardDrive hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setSecondDisk(HardDrive secondDisk) {
        this.secondDisk = secondDisk;
    }

    public String toString() {
        if (secondDisk != null) {
            return String.format("Computer parameters:\n%s\n%s\n%s\n%s\n", cpu, ram, hardDisk, secondDisk);
        }
        return String.format("Computer parameters:\n%s\n%s\n%s\n", cpu, ram, hardDisk);
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    private boolean hasAllComponents() {
        if (secondDisk != null) {
            return cpu != null && ram != null && hardDisk != null && secondDisk != null;
        }
        return cpu != null && ram != null && hardDisk != null;
    }

    public void turnOn() {
        if (isTurnedOn) {
            System.err.println("The computer is already turned on.");
        } else if (!hasAllComponents()) {
            System.err.println("The computer does not have all the components.");
        } else {
            isTurnedOn = true;
            System.out.println("The computer is turned on.");
        }
    }

    public void turnOff() {
        if (isTurnedOn) {
            isTurnedOn = false;
            System.out.println("The computer is turned off.");
        }
    }

    public void addFile(long size) {
        if (isTurnedOn) {
            if (secondDisk != null && (hardDisk.addFile(size) || secondDisk.addFile(size))) {
                System.out.printf("%d GB file added successfully.\n", size);
            } else if (hardDisk.addFile(size)) {
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
            if (secondDisk != null && (hardDisk.deleteFile(size) || secondDisk.deleteFile(size))) {
                System.out.printf("%d GB file has been deleted.\n", size);
            } else if (hardDisk.deleteFile(size)) {
                System.out.printf("%d GB file has been deleted.\n", size);
            } else {
                System.err.printf("%d GB cannot be deleted.\n", size);
            }
        } else {
            System.err.println("Computer is turned off.");
        }
    }
}
