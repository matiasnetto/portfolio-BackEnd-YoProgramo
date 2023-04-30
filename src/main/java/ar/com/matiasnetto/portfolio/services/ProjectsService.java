package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.dto.ProjectsInDTO;
import ar.com.matiasnetto.portfolio.exceptions.ResourceNotFoundException;
import ar.com.matiasnetto.portfolio.mappers.ProjectsInToProjects;
import ar.com.matiasnetto.portfolio.models.Projects;
import ar.com.matiasnetto.portfolio.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {
    @Autowired
    ProjectsRepository repository;
    @Autowired
    ProjectsInToProjects mapper;
    public List<Projects> getAllProjects() {
       return  this.repository.findAll();
    }

    public Projects createNewProject(ProjectsInDTO projectsInDTO) {
        Projects myProject = this.mapper.map(projectsInDTO);
        return this.repository.save(myProject);
    }

    public Projects deleteProject(int id) {
        Optional<Projects> myProject = this.repository.findById(id);

        if (myProject.isEmpty()) {throw new ResourceNotFoundException("Project", "id", String.valueOf(id));}

        this.repository.deleteById(id);
        return myProject.get();
    }

    public Projects updateProject(ProjectsInDTO projectsInDTO, int id) {
        Optional<Projects> myProject = this.repository.findById(id);

        if (myProject.isEmpty()) {throw new ResourceNotFoundException("Project", "id", String.valueOf(id));}

        Projects newData = this.mapper.map(projectsInDTO);
        newData.setId(myProject.get().getId());

        return this.repository.save(newData);

    }
}
