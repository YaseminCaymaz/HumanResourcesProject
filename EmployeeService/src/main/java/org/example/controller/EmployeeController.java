package org.example.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.EmployeeAddRequestDto;
import org.example.dto.request.EmployeeUpdateRequestDto;
import org.example.dto.response.BaseResponse;
import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EMPLOYEE)
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(ADD)
    @Transactional
    @CrossOrigin("*")
    public ResponseEntity<BaseResponse<String>> add(@RequestBody EmployeeAddRequestDto dto){
        employeeService.add(dto);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                .status(200)
                .message("Kayıt Başarılı")
                .build());
    }

    @GetMapping(GETBYID)
    @CrossOrigin("*")
    public ResponseEntity<BaseResponse<Employee>> getById(@RequestParam Long id){
       return ResponseEntity.ok(BaseResponse.<Employee>builder()
               .status(200)
               .data(employeeService.getById(id))
               .build());
    }


    @PostMapping(UPDATE)
    @Transactional
    @CrossOrigin("*")
    public ResponseEntity<BaseResponse<String>> update(@RequestBody EmployeeUpdateRequestDto dto){
        employeeService.update(dto);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                .status(200)
                .message("Güncelleme Basarılı")
                .build());
    }
}
