package com.example.rest.training.apr2022.repo;

import com.example.rest.training.apr2022.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
