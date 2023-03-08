package cz.czechitas.ukol3.model;

public class Computer {

    private boolean isTurnedOn;
    private Processor cpu;
    private Ram ram;
    private HardDrive hardDisk;

    public Computer (Processor cpu, Ram ram, HardDrive hardDisk) {
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
}
