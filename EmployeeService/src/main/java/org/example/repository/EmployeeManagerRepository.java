package org.example.repository;

import org.example.entity.EmployeeManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeManagerRepository extends JpaRepository<EmployeeManager, Long> {

    Optional<EmployeeManager> findByEmail(String email);
}
