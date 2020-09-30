package web.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "authuser")
public class User {

    public User()
    {}
    public User(String name, String password, Role role) {
        this.name = name;
        this.password = password;
        roles.add(role);
    }

    public User(Long id,String name,String password ) {
        this.id = id;
        this.name = name;
        this.password = password;

    }
    //_______________________________________________
    public User(String password, String name, Long id) {
        this.id = id;
        this.name = name;
        this.password = password;

    }
    //_______________________________________________
    public User(String name, String password, List<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
    public User(Long id,String name, String password, List<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    //@OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval=true)
    private List<Role> roles;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public void setAuthorities(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
