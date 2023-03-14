package cz.czechitas.ukol3.model;

public class Processor {

    private String manufacturer;
    private long speed;
    private double speedInGHz;

    public Processor(String manufacturer, long speed) {
        this.manufacturer = manufacturer;
        this.speed = speed;
        speedInGHz = speed / 1_000_000_000d;
    }

    @Override
    public String toString() {
        return String.format("%s processor with core boost frequency %d Hz (%.1f GHz)", manufacturer, speed, speedInGHz);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public double getSpeedInGHz() {
        return speedInGHz;
    }

    public void setSpeedInGHz(double speedInGHz) {
        this.speedInGHz = speedInGHz;
    }
}
