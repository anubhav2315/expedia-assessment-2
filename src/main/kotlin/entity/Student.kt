package org.example.entity

import javax.persistence.*

@Entity
@Table(name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    val studentId: Long? = null,

    @Column(name = "student_name")
    val studentName: String,

    @ManyToMany(mappedBy = "students")
    val courses: MutableSet<Course> = mutableSetOf()
)
