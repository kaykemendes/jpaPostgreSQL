package br.com.kaykemendes.learningjpapostgres.PersonSB;

import br.com.kaykemendes.learningjpapostgres.Utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class PersonServiceSB {

    @Autowired
    @Qualifier("personRepositorySB")
    PersonRepositorySB personRepositorySB;

    public List<PersonSB> findAll() {
        return personRepositorySB.findAll();
    }

    public GenericResponse findAllGeneric(){
        return new GenericResponse(HttpStatus.OK, personRepositorySB.findAll());
    }

    public PersonSB findById(Long id) {
        PersonSB response;

        try{
            response = personRepositorySB.getOne(id);
        } catch (Exception e){
            response = null;
        }

        return response;
    }

    public PersonSB save(PersonSB personSB){
        return personRepositorySB.save(personSB);
    }

    public ResponseEntity update(String name, int age, String gender, Long id){

        if(personRepositorySB.existsById(id)){
            try {
                personRepositorySB.update(name, age, gender, id);

            } catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
            }

           return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    public void delete(Long id){
        personRepositorySB.deleteById(id);
    }

    public PersonSB findByName(String name) {
        return personRepositorySB.findByName(name);
    }

    public void saveByImport(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        ByteArrayInputStream inputFilestream = new ByteArrayInputStream(bytes);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFilestream ));
        String line = "";

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

}
