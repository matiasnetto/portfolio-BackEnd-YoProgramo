package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.dto.ProjectsInDTO;
import ar.com.matiasnetto.portfolio.models.Projects;
import ar.com.matiasnetto.portfolio.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectsController {
   @Autowired
    ProjectsService service;
    @GetMapping
    public List<Projects> getAllProjects() {
       return this.service.getAllProjects();
    }

    @PostMapping
    public Projects createNewProject(@RequestBody ProjectsInDTO projectsInDTO) {
        return  this.service.createNewProject(projectsInDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projects> updateProject(@RequestBody ProjectsInDTO projectsInDTO, @PathVariable int id) {
        Projects myProject = this.service.updateProject(projectsInDTO, id);
        return new ResponseEntity<>(myProject, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Projects> deleteProject(@PathVariable int id) {
        Projects deletedProject = this.service.deleteProject(id);
        return new ResponseEntity<>(deletedProject, HttpStatus.NO_CONTENT);
    }
}
