package org.example.manager;

import io.lettuce.core.support.caching.CacheAccessor;
import org.example.dto.response.RegisterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.example.constants.RestApiUrls.ACTIVATE_STATUS;
import static org.example.constants.RestApiUrls.DELETE_BY_TOKEN;
public interface AuthManager {

    @PostMapping("/create")
    public ResponseEntity<Boolean> createUser(@RequestBody RegisterResponseDto dto);
    @GetMapping(ACTIVATE_STATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId);
    @DeleteMapping(DELETE_BY_TOKEN)
    public ResponseEntity<Boolean> deleteByToken(@RequestParam String token);
}
