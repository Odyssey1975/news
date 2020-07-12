package web.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String series;
    private String model;
    private String color;

    public Car() {
            }
    public Car(String series,String model,String color) {
        this.series =series;
        this.model = model;
        this.color= color;
    }



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

    public Long getId() {
        return id;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }
}
