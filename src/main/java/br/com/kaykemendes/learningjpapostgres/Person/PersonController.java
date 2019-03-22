package br.com.kaykemendes.learningjpapostgres.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    @Qualifier("personRepository")
    PersonRepository personRepository;

    @GetMapping
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable("id") Long id) {
        return personRepository.findById(id);
    }

    @PostMapping
    public Person save(Person person){
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        personRepository.deleteById(id);
    }

}
