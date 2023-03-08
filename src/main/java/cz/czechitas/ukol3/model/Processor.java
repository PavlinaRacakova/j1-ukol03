package cz.czechitas.ukol3.model;

public class Processor {

    private String manufacturer;
    private long speed;

    public Processor (String manufacturer, long speed) {
        this.manufacturer = manufacturer;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s processor with core boost frequency %l Hz", manufacturer, speed);
    }
}
