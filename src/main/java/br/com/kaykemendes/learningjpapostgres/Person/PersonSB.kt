package br.com.kaykemendes.learningjpapostgres.Person

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "person")
class PersonSB(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        val id: Long?,

        @Column(name = "name", nullable = false)
        @NotNull(message = "Name is required")
        val name: String?,

        @Column(name = "age", nullable = false)
        @NotNull(message = "Age is required")
        val age: Int?,

        @Column(name = "gender", nullable = false)
        @NotNull(message = "Gender is required")
        val gender: String?

) { constructor() : this(null, null, null, null) {} }
