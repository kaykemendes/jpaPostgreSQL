package br.com.kaykemendes.learningjpapostgres.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    @Qualifier("personRepository")
    PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public ResponseEntity update(String name, int age, String gender, Long id){

        if(personRepository.existsById(id)){
            personRepository.update(name, age, gender, id);

           return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }

    public Person findByName(String name) {
        return personRepository.findByName(name);
    }
}
