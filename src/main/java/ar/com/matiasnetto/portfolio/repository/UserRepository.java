package ar.com.matiasnetto.portfolio.repository;

import ar.com.matiasnetto.portfolio.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
