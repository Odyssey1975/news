package web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

/*@Data
@NoArgsConstructor*/
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    public Role()
    {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role")
    private String role;

    public Role(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
