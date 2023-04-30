package ar.com.matiasnetto.portfolio.repository;

import ar.com.matiasnetto.portfolio.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {

}
