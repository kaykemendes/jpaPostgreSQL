package br.com.kaykemendes.learningjpapostgres.Person;

import br.com.kaykemendes.learningjpapostgres.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(Constants.PATH_PARAM_ID)
    public Optional<Person> findById(@PathVariable("id") Long id) {
        return personRepository.findById(id);
    }

    @PostMapping
    public Person save(@Valid @RequestBody Person person){
        return personRepository.save(person);
    }

    @PutMapping(Constants.PATH_PARAM_ID)
    public void update(@PathVariable("id") Long id,
                       @Valid @RequestBody Person person){
        personRepository.update(person.getName(), person.getAge(), person.getGender(), id);
    }

    @DeleteMapping(Constants.PATH_PARAM_ID)
    public void delete(@PathVariable("id") Long id){
        personRepository.deleteById(id);
    }

}
