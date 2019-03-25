package br.com.kaykemendes.learningjpapostgres.PersonSB;

import br.com.kaykemendes.learningjpapostgres.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonControllerSB {

    @Autowired
    PersonServiceSB personServiceSB;

    @GetMapping
    public List<PersonSB> findAll() {
        return personServiceSB.findAll();
    }

    @GetMapping("/name")
    public PersonSB findByName(@PathParam("name") String name) {
        return personServiceSB.findByName(name);
    }

    @GetMapping(Constants.PATH_PARAM_ID)
    public Optional<PersonSB> findById(@PathVariable("id") Long id) {
        return personServiceSB.findById(id);
    }

    @PostMapping
    public PersonSB save(@Valid @RequestBody PersonSB personSB){
        return personServiceSB.save(personSB);
    }

    @PutMapping(Constants.PATH_PARAM_ID)
    public void update(@PathVariable("id") Long id,
                       @Valid @RequestBody PersonSB personSB){
        personServiceSB.update(personSB.getName(), personSB.getAge(), personSB.getGender(), id);
    }

    @DeleteMapping(Constants.PATH_PARAM_ID)
    public void delete(@PathVariable("id") Long id){
        personServiceSB.delete(id);
    }

}
