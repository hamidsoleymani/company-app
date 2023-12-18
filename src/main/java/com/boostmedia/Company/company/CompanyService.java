package com.boostmedia.Company.company;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyDto save(CompanyDto dto) {
        Company c = new Company(dto.companyName());
        c = this.companyRepository.save(c);
        return new CompanyDto(c.getId(), c.getCompanyName(), Collections.EMPTY_LIST);
    }

    public CompanyDto update(CompanyDto dto) {
        Company c = this.companyRepository.findById(dto.id()).orElseThrow(() -> new NoSuchElementException("Company with Id (" +
                dto.id() + ") not found"));
        c.setCompanyName(dto.companyName());
        this.companyRepository.save(c);
        return new CompanyDto(c.getId(), c.getCompanyName(), Collections.EMPTY_LIST);
    }

    public CompanyDto get(Long id) {
        Company c = getCompany(id);
        return new CompanyDto(c.getId(), c.getCompanyName(), Collections.EMPTY_LIST);
    }

    public Company getCompany(Long id) {

       return this.companyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Company with Id (" +
                id + ") not found"));
    }

    public void delete(Long id) {
        this.companyRepository.deleteById(id);
    }

    public Iterable<CompanyDto> getAll() {
        List<Company> all = (List<Company>) this.companyRepository.findAll();
        return all.stream().map(c -> new CompanyDto(c.getId(), c.getCompanyName(), Collections.EMPTY_LIST)).toList();
    }
}
