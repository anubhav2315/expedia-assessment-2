package org.example.repository

import org.example.entity.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {

    fun findByCourseName(courseName: String): Course?
}