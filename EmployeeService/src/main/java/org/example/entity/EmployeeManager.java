package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_employee_manager")
public class EmployeeManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private Long salary;
    private Long prim;
    private Long expense;
    private int dayOff;
    private String position;
    private String debit; //zimmet
    // private Double shift; //vardiya
    // private Double  mola; // daha sonra bakılacak

}
