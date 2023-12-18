package com.boostmedia.Company.company;

import com.boostmedia.Company.employee.EmployeeDto;

import java.util.List;

public record CompanyDto(Long id, String companyName, List<EmployeeDto> employeeDtoList) {
}
