package ar.com.matiasnetto.portfolio.models;

import ar.com.matiasnetto.portfolio.utils.AuthorityName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name = "authorities")
public class Authority {

    public Authority(AuthorityName name) {
        this.name = name;
    }

    public Authority() {
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;
}
