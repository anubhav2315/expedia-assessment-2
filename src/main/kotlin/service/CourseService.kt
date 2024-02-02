package org.example.service

import org.example.entity.Course
import org.example.entity.Student
import org.example.repository.CourseRepository
import org.example.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CourseService @Autowired constructor(
    private val courseRepository: CourseRepository,
    private val studentRepository: StudentRepository
) {

    @Transactional
    fun enrollStudentInCourse(studentId: Long, courseName: String) {
        val student = studentRepository.findById(studentId).orElseThrow {
            IllegalArgumentException("Student with ID $studentId not found.")
        }

        val course = courseRepository.findByCourseName(courseName) ?: Course(courseName = courseName)
        course.students.add(student)
        courseRepository.save(course)
    }

    @Transactional(readOnly = true)
    fun getStudentsInCourse(courseName: String): List<Student> {
        val course = courseRepository.findByCourseName(courseName)
        return course?.students?.toList() ?: emptyList()
    }
}
