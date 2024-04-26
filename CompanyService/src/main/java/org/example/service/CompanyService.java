package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
}
