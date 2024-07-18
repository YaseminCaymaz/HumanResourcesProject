package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.request.CompanyAddRequestDto;
import org.example.entity.Company;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-17T11:10:06+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public Company fromCompanyAddRequestDtoToCompany(CompanyAddRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company.CompanyBuilder<?, ?> company = Company.builder();

        company.email( dto.getEmail() );

        return company.build();
    }
}
