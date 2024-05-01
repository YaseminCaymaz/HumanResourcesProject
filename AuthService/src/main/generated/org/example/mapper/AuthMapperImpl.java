package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.request.RegisterRequestDto;
import org.example.dto.response.RegisterResponseDto;
import org.example.entity.Auth;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-01T22:49:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public Auth fromAuthRequestDto(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.name( dto.getName() );
        auth.surname( dto.getSurname() );
        auth.email( dto.getEmail() );
        auth.password( dto.getPassword() );

        return auth.build();
    }

    @Override
    public Object fromAuthToCreateUserRequestDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        Object object = new Object();

        return object;
    }

    @Override
    public Auth fromRegisterRequestToAuth(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.name( dto.getName() );
        auth.surname( dto.getSurname() );
        auth.email( dto.getEmail() );
        auth.password( dto.getPassword() );

        return auth.build();
    }

    @Override
    public RegisterResponseDto fromAuthToRegisterResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterResponseDto.RegisterResponseDtoBuilder registerResponseDto = RegisterResponseDto.builder();

        registerResponseDto.email( auth.getEmail() );
        registerResponseDto.password( auth.getPassword() );
        registerResponseDto.activationCode( auth.getActivationCode() );

        return registerResponseDto.build();
    }
}