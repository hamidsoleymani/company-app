package com.boostmedia.Company.company;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/company/", consumes ="application/json")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(value = "save", produces = MediaType.APPLICATION_JSON_VALUE )
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
