package org.example.service;

import org.example.dto.request.LoginRequestDto;
import org.example.dto.request.RegisterRequestDto;
import org.example.dto.response.RegisterResponseDto;
import org.example.entity.Auth;
import org.example.exception.AuthServiceException;
import org.example.exception.ErrorType;
import org.example.manager.AuthManager;
import org.example.mapper.AuthMapper;
import org.example.repository.AuthRepository;
import org.example.utility.CodeGenerator;

import org.example.utility.JwtTokenManager;
import org.example.utility.ServiceManager;
import org.example.utility.enums.EStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {
    private final AuthRepository authRepository;
    private final JwtTokenManager jwtTokenManager;

    private final AuthManager authManager;
    private final CacheManager cacheManager;
    public AuthService(AuthRepository authRepository, AuthManager authManager, JwtTokenManager jwtTokenManager, CacheManager cacheManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.authManager = authManager;
        this.jwtTokenManager = jwtTokenManager;
        this.cacheManager = cacheManager;
    }

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
        if(auth.isEmpty()){
            throw new AuthServiceException(ErrorType.ERROR_INVALID_LOGIN_PARAMETER);
        }
        if(auth.get().getStatus().equals(EStatus.ACTIVE)){
            return jwtTokenManager.createToken(auth.get().getId(),auth.get().getRole())
                    .orElseThrow(()->{throw new AuthServiceException(ErrorType.ERROR_CREATE_TOKEN);});
        }
        else {
            throw new AuthServiceException(ErrorType.ERROR_ACCOUNT_NOT_ACTIVE);
        }
    }


    @Transactional
    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth = AuthMapper.INSTANCE.fromRegisterRequestToAuth(dto);
        auth.setActivationCode(CodeGenerator.generateCode());
        save(auth);
//        try {
        authManager.createUser(AuthMapper.INSTANCE.fromAuthToCreateUserRequestDto(auth));
        cacheManager.getCache("findByRole").evict(auth.getRole().toString().toUpperCase());
//        } catch (Exception e){
//            e.printStackTrace();
//            delete(auth);
//        }
        return AuthMapper.INSTANCE.fromAuthToRegisterResponseDto(auth);
    }
}
