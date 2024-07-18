package org.example.manager;

import org.example.dto.response.RegisterResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.example.constants.RestApiUrls.*;
@FeignClient(url = "https://localhost:9092/dev/v1/company", name = "auth-company")

public interface AuthManager {

    @PostMapping("/create-manager")
    public ResponseEntity<Boolean> registerUser(@RequestBody RegisterResponseDto dto);
    @GetMapping(ACTIVATE_STATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable("authId") Long authId);
    @DeleteMapping(DELETE_BY_TOKEN)
    public ResponseEntity<Boolean> deleteByToken(@RequestParam("token") String token);
}
