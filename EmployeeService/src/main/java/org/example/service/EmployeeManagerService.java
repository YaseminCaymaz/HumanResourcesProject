package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repository.EmployeeManagerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeManagerService {
    private final EmployeeManagerRepository employeeManagerRepository;

}
