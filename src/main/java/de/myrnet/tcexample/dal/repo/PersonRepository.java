package de.myrnet.tcexample.dal.repo;

import de.myrnet.tcexample.dal.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastname(String lastname);

}
