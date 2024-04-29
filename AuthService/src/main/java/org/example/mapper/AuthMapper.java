package org.example.mapper;

import org.example.dto.request.RegisterRequestDto;
import org.example.dto.response.RegisterResponseDto;
import org.example.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    Auth fromAuthRequestDto(final RegisterRequestDto dto);

    Object fromAuthToCreateUserRequestDto(final Auth auth);

    Auth fromRegisterRequestToAuth(final RegisterRequestDto dto);

    RegisterResponseDto fromAuthToRegisterResponseDto(Auth auth);
}