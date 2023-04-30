package ar.com.matiasnetto.portfolio.mappers;

import ar.com.matiasnetto.portfolio.dto.ProjectsInDTO;
import ar.com.matiasnetto.portfolio.models.Projects;
import ar.com.matiasnetto.portfolio.models.Skills;
import ar.com.matiasnetto.portfolio.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProjectsInToProjects implements IMapper<ProjectsInDTO, Projects>{
    @Autowired
    SkillsRepository skillsRepository;
    @Override
    public Projects map(ProjectsInDTO in) {
        Projects myProjects = new Projects();

        myProjects.setTitle(in.getTitle());
        myProjects.setImage_url(in.getImage_url());
        myProjects.setEnd_at(in.getEnd_at());
        myProjects.setDescription(in.getDescription());
        myProjects.setProject_url(in.getProject_url());
        myProjects.setGithub_url(in.getGithub_url());
        myProjects.setOrd(in.getOrd());

        System.out.println(in.getTechnologies_ids());

        List<Skills> mySkills = this.skillsRepository.findAllById(in.getTechnologies_ids());

        System.out.println(mySkills);

       myProjects.setTechnologies(new HashSet<>(mySkills));

        return myProjects;
    }
}
