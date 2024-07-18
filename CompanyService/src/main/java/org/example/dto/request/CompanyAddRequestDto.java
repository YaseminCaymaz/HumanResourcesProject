package org.example.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CompanyAddRequestDto {

    @NotEmpty
    private String companyName;
    private String surname;

    @NotEmpty
    @Email
    private String email;
    private String password;
    private Long authId;


}
