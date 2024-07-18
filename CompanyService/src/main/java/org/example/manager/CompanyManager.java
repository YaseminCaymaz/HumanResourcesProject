package org.example.manager;

import org.example.dto.request.CompanyAddRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9090/dev/v1/auth",name = "company-auth")

public interface CompanyManager {
    @PutMapping("/update-email")
    public ResponseEntity<Boolean> updateEmail(@RequestBody CompanyAddRequestDto dto);
}
