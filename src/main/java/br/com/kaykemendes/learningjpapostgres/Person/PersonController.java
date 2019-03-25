package br.com.kaykemendes.learningjpapostgres.Person;

import br.com.kaykemendes.learningjpapostgres.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/name")
    public Person findByName(@PathParam("name") String name) {
        return personService.findByName(name);
    }

    @GetMapping(Constants.PATH_PARAM_ID)
    public Optional<Person> findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person save(@Valid @RequestBody Person person){
        return personService.save(person);
    }

    @PutMapping(Constants.PATH_PARAM_ID)
    public void update(@PathVariable("id") Long id,
                       @Valid @RequestBody Person person){
        personService.update(person.getName(), person.getAge(), person.getGender(), id);
    }

    @DeleteMapping(Constants.PATH_PARAM_ID)
    public void delete(@PathVariable("id") Long id){
        personService.delete(id);
    }

}
