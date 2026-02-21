package com.ak.project.springBoot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ak.project.springBoot.enity.Employee;
import com.ak.project.springBoot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepo;
	
	public EmployeeService(EmployeeRepository repository) {
		this.employeeRepo = repository;
	}
	
	public Employee createEmployee(Employee emp) {
        return employeeRepo.save(emp);

	}
	
	public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("There is some issue"));
	}
	

	  public String updateEmployee(Employee emp) {
          Employee employee = employeeRepo.findById(emp.getId()).orElse(new Employee());
          employee.setDepartmentName(emp.getDepartmentName());
        return employeeRepo.save(employee).getName()+" data updated";
      }

      public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
      }
	
}
