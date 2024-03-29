package com.boostmedia.Company.employee;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/Employee/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value= "save", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto save(@RequestBody EmployeeDto dto) {
        return this.employeeService.save(dto);
    }

   /*n @PutMapping("update")
    public EmployeeDto update(@RequestBody EmployeeDto dto) {
        return this.employeeService.update(dto);
    }

    */

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        this.employeeService.delete(id);
    }

    @GetMapping("{id}")
    public EmployeeDto get(@PathVariable Long id) {
        return this.employeeService.get(id);
    }

    @GetMapping("all")
    public Iterable<EmployeeDto> getAll() {
        return this.employeeService.getAll();
    }
}
