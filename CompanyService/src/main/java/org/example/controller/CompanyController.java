package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.CompanyAddRequestDto;
import org.example.dto.request.CompanyUpdateRequestDto;
import org.example.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.example.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMPANY)
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/create-manager")
    public ResponseEntity<Void> createManager(@RequestBody CompanyAddRequestDto dto) {
        companyService.createManager(dto);
        return ResponseEntity.ok().build();
    }

    /*@PutMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody CompanyUpdateRequestDto dto){
        return ResponseEntity.ok(companyService.update(dto));
    }

     */
    @GetMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId){
        return ResponseEntity.ok(companyService.activateStatus(authId));
    }

    @GetMapping(REJECT_STATUS)
    public ResponseEntity<Boolean> rejectStatus(@PathVariable("authId") Long authId){
        return ResponseEntity.ok(companyService.rejectstatus(authId));
    }

}