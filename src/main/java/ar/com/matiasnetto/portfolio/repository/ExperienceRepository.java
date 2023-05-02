package ar.com.matiasnetto.portfolio.repository;

import ar.com.matiasnetto.portfolio.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}
