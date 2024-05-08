package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long companyId;
    @Size(min=11,max = 11, message = "TC numarası 11 karakterli olmalidir.")
    @Column(unique = true)
    private Long TCNo;
    @Size(min = 2, max=20,message = "Kullanici adi en az 3, en fazla 20 karakter olabilir.")
    private String name;
    @Size(min = 2, max=20,message = "Kullanici adi en az 3, en fazla 20 karakter olabilir.")
    private String surname;
    @Column(unique = true)
    @Email
    private String email;
    @Size(min=11,max = 11, message = "Telefon numarasi 11 karakterli olmalidir.")
    private String phone;
    private String maritalStatus; // medeni hali
    private String gender;
    private Long dateOfBirth;
    private int numberOfChildren;
    private Long createAt;
    private Long updateAt;
    private Boolean isActive;
    @OneToOne
    @JoinColumn(name = "employeeManagerId")
    private EmployeeManager employeeManager;
}
