package com.ak.project.springBoot.controller;

import com.ak.project.springBoot.enity.Employee;
import com.ak.project.springBoot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{name}")
    public Employee getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployee(name);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping
    public String updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping
    public String deleteEmployee(@RequestBody Employee emp){
        employeeService.deleteEmployee(emp);
        return "Employee deleted successfully";
    }
}
