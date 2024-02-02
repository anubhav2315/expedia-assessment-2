package org.example.repository

import javax.persistence.*

@Entity
@Table(name = "employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    val employeeId: Long? = null,

    @Column(name = "employee_name")
    val employeeName: String,

    @ManyToOne
    @JoinColumn(name = "department_id")
    val department: Department,

    @ManyToMany
    @JoinTable(
        name = "employee_project",
        joinColumns = [JoinColumn(name = "employee_id")],
        inverseJoinColumns = [JoinColumn(name = "project_id")]
    )
    val projects: MutableSet<Project> = mutableSetOf()
)
