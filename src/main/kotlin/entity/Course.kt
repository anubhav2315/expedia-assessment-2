package org.example.entity

import javax.persistence.*

@Entity
@Table(name = "courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    val courseId: Long? = null,

    @Column(name = "course_name")
    val courseName: String,

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = [JoinColumn(name = "course_id")],
        inverseJoinColumns = [JoinColumn(name = "student_id")]
    )
    val students: MutableSet<Student> = mutableSetOf()
)
