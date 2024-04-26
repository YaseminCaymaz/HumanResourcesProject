package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
}
