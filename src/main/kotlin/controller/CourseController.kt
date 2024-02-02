package org.example.controller

import org.example.entity.Student
import org.example.service.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/courses")
class CourseController @Autowired constructor(private val courseService: CourseService) {

    @PostMapping("/enroll-student")
    fun enrollStudentInCourse(
        @RequestParam studentId: Long,
        @RequestParam courseName: String
    ) {
        courseService.enrollStudentInCourse(studentId, courseName)
    }

    @GetMapping("/students-in-course")
    fun getStudentsInCourse(@RequestParam courseName: String): List<Student> {
        return courseService.getStudentsInCourse(courseName)
    }
}
