package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@Entity()
@Table(name = "user")
@ToString
public class User {

    public User(String email, String username, String password, List<Authority> authorities) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public User() {
    }

    @Id() @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String username;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

}
