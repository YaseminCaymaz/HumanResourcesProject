package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.LoginRequestDto;
import org.example.dto.request.RegisterRequestDto;
import org.example.dto.response.BaseResponse;
import org.example.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.example.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService authService;
  //  private final JwtTokenManager jwtTokenManager;


    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<String> login(LoginRequestDto dto) {

        return ResponseEntity.ok(authService.login(dto));
    }


    @PostMapping(REGISTER)
    @CrossOrigin("*")
   public ResponseEntity<BaseResponse<String>> register(@RequestBody RegisterRequestDto dto) {
        authService.save(dto);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                        .status(200)
                        .message("Kayıt Başarılı")

                .build());

    }
}
