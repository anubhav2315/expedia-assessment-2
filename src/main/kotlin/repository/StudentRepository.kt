package org.example.repository

import org.example.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StudentRepository : JpaRepository<Student, Long> {

    @Query("SELECT s.studentName, c.courseName FROM Student s LEFT JOIN FETCH s.courses c")
    fun getStudentsAndCourses(): List<Array<Any>>
}
