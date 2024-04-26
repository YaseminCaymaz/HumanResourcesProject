package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
}
