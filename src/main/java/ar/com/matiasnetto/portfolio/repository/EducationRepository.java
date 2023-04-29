package ar.com.matiasnetto.portfolio.repository;

import ar.com.matiasnetto.portfolio.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
}
