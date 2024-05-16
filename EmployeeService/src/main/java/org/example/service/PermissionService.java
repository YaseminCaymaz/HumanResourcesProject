package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.PermissionRequestAddDto;
import org.example.entity.Permission;
import org.example.exception.EmployeeServiceException;
import org.example.exception.ErrorType;
import org.example.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;

    public void save(PermissionRequestAddDto dto) {
        permissionRepository.save(Permission.builder()
                .employeeId(dto.getEmployeeId())
                .permissionType(dto.getPermissionType())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .createdAt(new Date(System.currentTimeMillis()))
                .build());
    }


    public List<Permission> getAllByEmployeeId(Long id) {
        List<Permission> permissionList = permissionRepository.getAllByEmployeeId(id);
        if (permissionList.isEmpty()){
            throw new EmployeeServiceException(ErrorType.ERROR_PERMISSION_NOT_FOUND);
        }
        return permissionList;
    }

}
