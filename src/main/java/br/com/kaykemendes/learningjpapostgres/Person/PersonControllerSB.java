package br.com.kaykemendes.learningjpapostgres.Person;

import br.com.kaykemendes.learningjpapostgres.Utils.Constants;
import br.com.kaykemendes.learningjpapostgres.Utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

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

    @GetMapping("/generic")
    public GenericResponse findAllGeneric(){
        return personServiceSB.findAllGeneric();
    }

//    @GetMapping("/paganitor")
//    public Page<Person> findPaged(){
//        return personServiceSB.findPaged();
//    }

    @GetMapping(Constants.PATH_PARAM_ID)
    public PersonSB findById(@PathVariable("id") Long id) {
        return personServiceSB.findById(id);
    }

    @PostMapping
    public PersonSB save(@Valid @RequestBody PersonSB personSB){
        return personServiceSB.save(personSB);
    }

    @PostMapping("/import")
    public void saveByImport(@RequestParam("file") MultipartFile file) throws IOException {
        personServiceSB.saveByImport(file);
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
