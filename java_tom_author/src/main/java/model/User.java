package model;

import javax.persistence.*;

@Entity
@Table(name = "factory")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String country;
    private String role;

    public User() {
    }

    public User(String login, String password, String country,String role) {
        this.login = login;
        this.password = password;
        this.country = country;
        this.role = role;
    }

    public User(Integer id, String login, String password, String country,String role) {
        this.login = login;
        this.password = password;
        this.country = country;
        this.role=role;
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
