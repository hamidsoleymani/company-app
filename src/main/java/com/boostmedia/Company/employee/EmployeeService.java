package com.boostmedia.Company.employee;

import com.boostmedia.Company.autoconfiguration.AppConfig;
import com.boostmedia.Company.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    private AppConfig appConfig;
    private final CompanyService companyService;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(CompanyService companyService, EmployeeRepository employeeRepository, AppConfig appConfig) {
        this.companyService = companyService;
        this.employeeRepository = employeeRepository;
        this.appConfig = appConfig;
    }

    public EmployeeDto save(EmployeeDto dto) {
        Employee em = new Employee(dto.name(), this.companyService.getCompany(dto.companyId()));
        em = this.employeeRepository.save(em);
        return new EmployeeDto(em.getId(), em.getName(), em.getCompanyCC().getId());
    }

 /*   public EmployeeDto update(EmployeeDto dto) {
        Employee c = this.employeeRepository.findById(dto.id()).orElseThrow(() -> new NoSuchElementException("Employee with Id (" +
                dto.id() + ") not found"));
        c.setEmployeeName(dto.EmployeeName());
        this.employeeRepository.save(c);
        return new EmployeeDto(c.getId(), c.getEmployeeName());
    }

  */

    public EmployeeDto get(Long id) {
        Employee emp = this.employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee with Id (" +
                id + ") not found"));
        return new EmployeeDto(emp.getId(), emp.getName(), emp.getCompanyCC().getId());
    }

    public void delete(Long id) {
        this.employeeRepository.deleteById(id);
    }

    public Iterable<EmployeeDto> getAll() {
        List<Employee> all = (List<Employee>) this.employeeRepository.findAll();
        return all.stream().map(c -> new EmployeeDto(c.getId(), c.getName(), c.getCompanyCC().getId())).toList();
    }
}
