package ar.com.matiasnetto.portfolio.repository;


import ar.com.matiasnetto.portfolio.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Integer> {

}
