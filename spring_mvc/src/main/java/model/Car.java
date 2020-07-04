package model;

public class Car {
    private String series;
    private String model;
    private String color;

    public String getSeries() {
        return series;
    }

    public Car setSeries(String series) {
        this.series = series;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;

    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }
}
