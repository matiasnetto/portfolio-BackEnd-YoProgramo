package ar.com.matiasnetto.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class ProjectsInDTO {
    private String title;
    private String image_url;
    private Date end_at;
    private String description;
    private String project_url;
    private String github_url;
    private int ord;
    private List<Integer> technologies_ids;
}
