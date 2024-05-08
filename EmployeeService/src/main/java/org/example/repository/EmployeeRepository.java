package org.example.repository;

import org.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findOptionalById(Long id);

    Optional<Employee> findOptionalByAuthId(Long authId);
}
