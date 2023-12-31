package com.boostmedia.Company.company;

import com.boostmedia.Company.employee.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "company")
public class Company {
    /**
     * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bestell_formular_seq_gen")
     * @SequenceGenerator(name = "bestell_formular_seq_gen", sequenceName = "bestell_formular_seq", allocationSize = 1)
     * @Id var id: Long? = null,
     * <p>
     * create sequence bestell_formular_seq as bigint start 1 increment 1;
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq", sequenceName = "company_seq", allocationSize = 1)
    @Id
    private Long id;
    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "companyCC")
    private List<Employee> employeeList;

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
