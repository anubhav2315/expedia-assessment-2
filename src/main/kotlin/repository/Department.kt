package org.example.repository

import javax.persistence.*

@Entity
@Table(name = "departments")
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    val departmentId: Long? = null,

    @Column(name = "department_name")
    val departmentName: String
)
