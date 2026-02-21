package com.ak.project.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.project.springBoot.enity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Optional<Employee> findByName(String name);
}
