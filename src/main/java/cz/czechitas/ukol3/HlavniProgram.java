package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Computer;
import cz.czechitas.ukol3.model.HardDrive;
import cz.czechitas.ukol3.model.Processor;
import cz.czechitas.ukol3.model.Ram;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        HardDrive hardDisk = new HardDrive(512L);
        Ram ram = new Ram(16L);
        Processor cpu = new Processor("Intel Core i5", 4_400_000_000L);
        Computer myComputer = new Computer(cpu, ram, hardDisk);
        myComputer.turnOn();
        myComputer.turnOn();
        myComputer.turnOff();
        myComputer.turnOff();
    }

}
