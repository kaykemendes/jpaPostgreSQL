package br.com.kaykemendes.learningjpapostgres.PersonSB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceSB {

    @Autowired
    @Qualifier("personRepositorySB")
    PersonRepositorySB personRepositorySB;

    public List<PersonSB> findAll() {
        return personRepositorySB.findAll();
    }

    public Optional<PersonSB> findById(Long id) {
        return personRepositorySB.findById(id);
    }

    public PersonSB save(PersonSB personSB){
        return personRepositorySB.save(personSB);
    }

    public ResponseEntity update(String name, int age, String gender, Long id){

        if(personRepositorySB.existsById(id)){
            personRepositorySB.update(name, age, gender, id);

           return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    public void delete(Long id){
        personRepositorySB.deleteById(id);
    }

    public PersonSB findByName(String name) {
        return personRepositorySB.findByName(name);
    }
}
