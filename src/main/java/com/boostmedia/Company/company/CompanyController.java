package com.boostmedia.Company.company;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/company/")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("save")
    public CompanyDto save(@RequestBody CompanyDto dto) {
        return this.companyService.save(dto);
    }

    @PutMapping("update")
    public CompanyDto update(@RequestBody CompanyDto dto) {
        return this.companyService.update(dto);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        this.companyService.delete(id);
    }

    @GetMapping("{id}")
    public CompanyDto get(@PathVariable Long id) {
        return this.companyService.get(id);
    }

    @GetMapping("all")
    public Iterable<CompanyDto> getAll() {
        return this.companyService.getAll();
    }
}
