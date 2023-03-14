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

    public Processor getCpu() {
        return cpu;
    }

    public HardDrive getHardDisk() {
        return hardDisk;
    }

    public Ram getRam() {
        return ram;
    }

    public HardDrive getSecondDisk() {
        return secondDisk;
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
            return cpu != null && ram != null && hardDisk != null;
        }
        return cpu != null && ram != null && hardDisk != null;
    }

    public void turnOn() {
        if (!hasAllComponents()) {
            System.err.println("The computer does not have all the components.");
            return;
        }

        if (isTurnedOn) {
            System.err.println("The computer is already turned on.");
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
        if (!isTurnedOn) {
            System.err.println("Computer is turned off.");
            return;
        }

        if (secondDisk != null && (hardDisk.isPossibleToAddFile(size) || secondDisk.isPossibleToAddFile(size))) {
            if (hardDisk.isPossibleToAddFile(size)) {
                hardDisk.setUsedSpace(hardDisk.getUsedSpace() + size);
            } else {
                secondDisk.setUsedSpace(secondDisk.getUsedSpace() + size);
            }
            System.out.printf("%d GB file added successfully.\n", size);
        } else if (hardDisk.isPossibleToAddFile(size)) {
            hardDisk.setUsedSpace(hardDisk.getUsedSpace() + size);
            System.out.printf("%d GB file added successfully.\n", size);
        } else {
            System.err.printf("%d GB file is too large.\n", size);
        }
    }

    public void deleteFile(long size) {
        if (!isTurnedOn) {
            System.err.println("Computer is turned off.");
            return;
        }

        if (secondDisk != null && (hardDisk.isPossibleToDeleteFile(size) || secondDisk.isPossibleToDeleteFile(size))) {
            if (hardDisk.isPossibleToDeleteFile(size)) {
                hardDisk.setUsedSpace(hardDisk.getUsedSpace() - size);
            } else {
                secondDisk.setUsedSpace(secondDisk.getUsedSpace() - size);
            }
            System.out.printf("%d GB file has been deleted.\n", size);
        } else if (hardDisk.isPossibleToDeleteFile(size)) {
            hardDisk.setUsedSpace(hardDisk.getUsedSpace() - size);
            System.out.printf("%d GB file has been deleted.\n", size);
        } else {
            System.err.printf("%d GB cannot be deleted.\n", size);
        }
    }
}
