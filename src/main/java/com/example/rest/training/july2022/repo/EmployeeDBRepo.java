package com.example.rest.training.july2022.repo;

import com.example.rest.training.july2022.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDBRepo extends JpaRepository<Employee, Integer> {
}
