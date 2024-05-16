package org.example.repository;

import org.example.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Company, Long> {
}
