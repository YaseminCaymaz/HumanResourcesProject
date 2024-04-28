package org.example.repository;

import org.example.entity.EmployeeManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeManagerRepository extends JpaRepository<EmployeeManager, Long> {
}
