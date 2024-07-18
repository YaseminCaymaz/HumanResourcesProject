package org.example.service;

import org.example.dto.request.CompanyAddRequestDto;
import org.example.entity.Company;
import org.example.entity.Manager;
import org.example.exception.CompanyServiceException;
import org.example.exception.ErrorType;
import org.example.repository.CompanyRepository;
import org.example.repository.ManagerRepository;
import org.example.utility.JwtTokenManager;
import org.example.utility.ServiceManager;
import org.example.utility.enums.EStatus;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@EnableFeignClients
@EnableCaching
public class CompanyService extends ServiceManager<Company, Long> {

    private final CompanyRepository companyRepository;
    private final ManagerRepository managerRepository;
    private final CacheManager cacheManager;
    private final JwtTokenManager jwtTokenManager;


    public CompanyService(CompanyRepository companyRepository, ManagerRepository managerRepository, CacheManager cacheManager, JwtTokenManager jwtTokenManager) {
        super(companyRepository);
        this.companyRepository = companyRepository;
        this.managerRepository = managerRepository;
        this.cacheManager = cacheManager;
        this.jwtTokenManager = jwtTokenManager;
    }


    public void saveCompany(Company company) {
        try {
            companyRepository.save(company);
        } catch (Exception e) {
            throw new CompanyServiceException(ErrorType.INTERNAL_ERROR);
        }
    }
    public boolean createManager(CompanyAddRequestDto dto) {
        Manager manager = new Manager();
        manager.setName(dto.getCompanyName());
        manager.setSurname(dto.getSurname());
        manager.setPassword(dto.getPassword());
        manager.setEmail(dto.getEmail());
        manager.setAuthId(dto.getAuthId());
        managerRepository.save(manager);
        return true;
    }


    /*public Boolean update(CompanyUpdateRequestDto dto){
        Optional<Long> authId = JwtTokenManager.getIdFromToken(dto.getToken());
        if(authId.isEmpty()){
            throw new CompanyServiceException(ErrorType.INVALID_TOKEN);
        }
        Optional<Company> optionalUserProfile = companyRepository.findByAuthId(authId.get());
        if (optionalUserProfile.isEmpty()){
            throw new CompanyServiceException(ErrorType.COMPANY_NOT_FOUND);
        }


        Company company = optionalUserProfile.get();
        company.setEmail(dto.getEmail());
        company.setSector(dto.getSector());
        company.setCompanyName(dto.getCompanyName());
        update(company);
        cacheManager.getCache("findByUserName").evict(dto.getEmail().toLowerCase());
        cacheManager.getCache("findByRole").clear();

        companyRepository.save(Company.builder()
                .name(company.getName())
                .email(company.getEmail())
                .sector(company.getSector())
                .build());
        return true;
    }

     */




    public Boolean activateStatus(Long authId) {
        Optional<Company> optionalUserProfile = companyRepository.findByAuthId(authId);
        if(optionalUserProfile.isPresent()){
            optionalUserProfile.get().setStatus(EStatus.APPROVED);
            update(optionalUserProfile.get());
            return true;
        } else {
            throw new CompanyServiceException(ErrorType.INTERNAL_ERROR);
        }
    }

    public Boolean rejectstatus(Long authId) {
        Optional<Company> optionalUserProfile = companyRepository.findByAuthId(authId);
        if(optionalUserProfile.isPresent()){
            optionalUserProfile.get().setStatus(EStatus.REJECTED);
            update(optionalUserProfile.get());
            return true;
        } else {
            throw new CompanyServiceException(ErrorType.INTERNAL_ERROR);
        }
    }


}


