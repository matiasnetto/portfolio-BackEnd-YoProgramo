package ar.com.matiasnetto.portfolio.repository;

import ar.com.matiasnetto.portfolio.models.Projects;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {

    @Modifying @Transactional
    @Query(value = "DELETE FROM technology_in_project WHERE technology_id = :id", nativeQuery = true)
    void deleteRelationsWithTechnologyId(@Param("id") int id);
}
