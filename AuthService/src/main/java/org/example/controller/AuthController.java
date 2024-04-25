package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.constants.RestApiUrls.AUTH;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService authService;

}
