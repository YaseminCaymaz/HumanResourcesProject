package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.constants.RestApiUrls.COMPANY;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMPANY)
public class CompanyController {
    private final CompanyService companyService;
}
