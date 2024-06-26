package org.example.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PermissionRequestAddDto {

    private Long employeeId;
    private String permissionType;
    private LocalDate startDate;
    private LocalDate endDate;
}
