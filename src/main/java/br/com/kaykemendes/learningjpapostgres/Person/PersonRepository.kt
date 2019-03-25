package br.com.kaykemendes.learningjpapostgres.Person

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

interface PersonRepository : JpaRepository<Person, Long> {

    fun findByName(name : String): Person

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Modifying
    @Query(value = "UPDATE person SET name = ?1, age = ?2, gender = ?3 WHERE id = ?4", nativeQuery = true)
    fun update(name: String, age: Int, gender: String, id: Long)

}