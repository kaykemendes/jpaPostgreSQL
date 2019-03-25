package br.com.kaykemendes.learningjpapostgres.PersonSB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepositorySB extends JpaRepository<PersonSB, Long> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Modifying
    @Query(value = "UPDATE person SET name = ?1, age = ?2, gender = ?3 WHERE id = ?4", nativeQuery = true)
    void update(String name, int age, String gender, Long id);

    PersonSB findByName(String name);
}