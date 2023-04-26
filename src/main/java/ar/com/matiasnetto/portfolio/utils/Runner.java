package ar.com.matiasnetto.portfolio.utils;

import ar.com.matiasnetto.portfolio.models.Authority;
import ar.com.matiasnetto.portfolio.models.Skills;
import ar.com.matiasnetto.portfolio.models.User;
import ar.com.matiasnetto.portfolio.repository.AuthorityRepository;
import ar.com.matiasnetto.portfolio.repository.SkillsRepository;
import ar.com.matiasnetto.portfolio.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private  final AuthorityRepository authorityRepository;
    private  final UserRepository userRepository;
    private final SkillsRepository skillsRepository;

    public Runner(AuthorityRepository authorityRepository, UserRepository userRepository, SkillsRepository skillsRepository) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.skillsRepository = skillsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.USER)
            ));

        }

        if (this.userRepository.count() == 0) {
            this.userRepository.saveAll(List.of(
                    new User("admin@admin.com","admin","password",List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("user@user.com","user","password",List.of(this.authorityRepository.findByName(AuthorityName.USER).get())))
            );
        }

        if (this.skillsRepository.count() == 0) {
            this.skillsRepository.saveAll(List.of(
                    new Skills( "Javascript","https://javascribp.com/img.jpg",80,1),
                    new Skills( "Angular","https://angular.com/img.jpg",50,2),
                    new Skills( "Java","https://java.com/img.jpg",50,2)
            ));
        }
    }
}
