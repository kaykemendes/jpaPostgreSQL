package br.com.kaykemendes.learningjpapostgres.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message="Name is required")
    private String name;

    @Column(name = "age", nullable = false)
    @NotNull(message="Age is required")
    private int age;

    @Column(name = "gender", nullable = false)
    @NotNull(message="Gender is required")
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
