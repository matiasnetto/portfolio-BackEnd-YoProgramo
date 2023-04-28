package ar.com.matiasnetto.portfolio.repository;

import ar.com.matiasnetto.portfolio.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
