package com.boostmedia.Company.employee;


import com.boostmedia.Company.company.Company;
import jakarta.persistence.*;

@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    @Id
    private Long id;

    @Column(name="employee_name")
    private String name;

    @ManyToOne
    private Company companyCC;

    public Employee(String name, Company companyCC){
        this.name= name;
        this.companyCC = companyCC;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompanyCC() {
        return companyCC;
    }

    public void setCompanyCC(Company company) {
        this.companyCC = company;
    }


}
