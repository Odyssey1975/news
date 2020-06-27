package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "series")
    private int series;
  public   Car()
    {

    }

    public Car ( String name, Integer series)
    {
        this.name=name;
        this.series =series;
    }

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public int getSeries() {
        return series;
    }

    public Car setSeries(int series) {
        this.series = series;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @OneToOne ( mappedBy="car")
    private User user;
}
