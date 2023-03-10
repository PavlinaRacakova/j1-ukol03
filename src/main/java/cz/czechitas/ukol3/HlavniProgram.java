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

        HardDrive asusHardDisk = new HardDrive(512L);
        HardDrive lenovoHardDisk = new HardDrive(520L);
        HardDrive lenovoSecondDisk = new HardDrive(330L);
        Ram asusRam = new Ram(16L);
        Ram lenovoRam = new Ram(8L);
        Processor asusCpu = new Processor("Intel Core i5", 4_400_000_000L);
        Processor lenovoCpu = new Processor("Intel Core i7", 4_600_000_000L);

        Computer asus = new Computer(asusCpu, asusRam, asusHardDisk);
        Computer lenovo = new Computer(lenovoCpu, lenovoRam, lenovoHardDisk, lenovoSecondDisk);
        Computer incompleteAsus = new Computer(asusCpu, null, null);
        Computer incompleteLenovo = new Computer (null, null, null, null);

        System.out.println(asus);
        System.out.println(lenovo);
        asus.turnOn();
        asus.addFile(12);
        asus.turnOff();
        asus.addFile(1000);
        asus.turnOn();
        asus.addFile(1000);
        asus.deleteFile(10);
        asus.deleteFile(100);
        lenovo.turnOn();
        lenovo.addFile(300);
        lenovo.addFile(300);
        lenovo.addFile(1000);
        lenovo.deleteFile(300);
        System.out.println("Lenovo hard disk used space: " + lenovoHardDisk.getUsedSpace());
        System.out.println("Lenovo second disk used space: " + lenovoSecondDisk.getUsedSpace());
        incompleteAsus.turnOn();
        incompleteAsus.addFile(30);
        incompleteLenovo.turnOn();
    }
}
