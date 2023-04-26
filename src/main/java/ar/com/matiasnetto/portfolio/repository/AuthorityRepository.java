package ar.com.matiasnetto.portfolio.repository;

import ar.com.matiasnetto.portfolio.models.Authority;
import ar.com.matiasnetto.portfolio.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    Optional<Authority> findByName(AuthorityName name);
}
