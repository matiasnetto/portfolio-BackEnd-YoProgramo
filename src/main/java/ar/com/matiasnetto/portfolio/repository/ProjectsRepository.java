package ar.com.matiasnetto.portfolio.repository;

import ar.com.matiasnetto.portfolio.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
}
