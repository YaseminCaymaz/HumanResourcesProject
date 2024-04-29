package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.LoginRequestDto;
import org.example.dto.request.RegisterRequestDto;
import org.example.entity.Auth;
import org.example.exception.AuthServiceException;
import org.example.exception.ErrorType;
import org.example.repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public void save(RegisterRequestDto dto) {
        authRepository.save(
                Auth.builder()
                        .name(dto.getName())
                        .surname(dto.getSurname())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .build()
        );
    }

    public String login(LoginRequestDto dto) {
        Optional<Auth> auth = authRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

        if (auth.isPresent()) {
            return "Login islemi basarili";
        }
        else {
            throw new AuthServiceException(ErrorType.USER_NOT_FOUND);
        }
    }
}
