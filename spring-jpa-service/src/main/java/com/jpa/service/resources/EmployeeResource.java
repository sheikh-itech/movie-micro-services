package com.jpa.service.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.beans.Address;
import com.jpa.service.beans.Employee;
import com.jpa.service.repositories.EmployeeRepository;

@RestController
@RequestMapping("employee")
public class EmployeeResource {

	@Autowired
	private EmployeeRepository empRepo;
	
	@RequestMapping("initialize")
	public void init() {
		
		List<Employee> emps = new ArrayList<>();
		
		Employee e1 = new Employee("Arham", new Address("Temporary", "Sunka Chauraha", "Sunka Chauraha", 480007));
		Employee e2 = new Employee("Hapheej", new Address("Temporary", "Sunka Chauraha", "Sunka Chauraha", 480007));
		Employee e3 = new Employee("Aastana", new Address("Temporary", "Sunka Chauraha", "Sunka Chauraha", 480007));
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		
		empRepo.saveAll(emps);
	}
	
	@RequestMapping("fetchAll")
	public ResponseEntity<List<Employee>> fetchAllEmp() {
		
		List<Employee> emps = new ArrayList<>();
		Iterable<Employee> empsItr = empRepo.findAll();
		empsItr.forEach(action->emps.add(action));
		
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
}
