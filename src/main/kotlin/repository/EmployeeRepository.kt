package org.example.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface EmployeeRepository : JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e JOIN FETCH e.projects p WHERE p.projectName = :projectName")
    fun findEmployeesByProjectName(@Param("projectName") projectName: String): List<Employee>
}
