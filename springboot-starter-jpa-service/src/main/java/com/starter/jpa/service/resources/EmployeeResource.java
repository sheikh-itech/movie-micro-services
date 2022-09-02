package com.starter.jpa.service.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starter.jpa.service.beans.Employee;
import com.starter.jpa.service.beans.Response;
import com.starter.jpa.service.repositories.EmployeeRepository;


@RestController
@RequestMapping("employee")
public class EmployeeResource {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@RequestMapping(value="save", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Response> saveEmployee(@RequestBody Employee employee) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), "Employee info saved...", employeeRepo.save(employee));
		
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="saveAll", method = RequestMethod.POST)
	public ResponseEntity<Response> saveEmployees(@RequestBody List<Employee> employees) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), "Employees info saved...", employeeRepo.saveAll(employees));
		
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="name", method = RequestMethod.GET)
	public ResponseEntity<Response> findByName(@RequestParam("name") String name) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info by name", employeeRepo.findByName(name));
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="nameContains", method = RequestMethod.GET)
	public ResponseEntity<Response> findByNameContaining(@RequestParam("name") String name) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info by contains name", employeeRepo.findByNameContaining(name));
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="nameAndMobile", method = RequestMethod.GET)
	public ResponseEntity<Response> findByNameAndMobile(@RequestParam("name") String name, @RequestParam("mobile") long mobile) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info by name and mobile", employeeRepo.findByNameAndMobile(name, mobile));
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="empTypeNotNull", method = RequestMethod.GET)
	public ResponseEntity<Response> findByEmpTypeNotNull() {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info by employeeType Not Null", employeeRepo.findByEmpTypeNotNull());
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="empType", method = RequestMethod.GET)
	public ResponseEntity<Response> findByEmpType(@RequestParam("empType") String empType) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info byEmpType", employeeRepo.findByEmpType(empType));
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="nameAndEmpTypeNotNull", method = RequestMethod.GET)
	public ResponseEntity<Response> findByNameAndEmpTypeNotNull(@RequestParam("name") String name) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info byNameAndEmpTypeNotNull", employeeRepo.findByNameAndEmpTypeNotNull(name));
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="guardianName", method = RequestMethod.GET)
	public ResponseEntity<Response> findByGuardianName(@RequestParam("guardianName") String name) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info byGuardianName", employeeRepo.findByGuardianName(name));
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	// Query/JPQL
	@RequestMapping(value="avgSalary", method = RequestMethod.GET)
	public ResponseEntity<Response> findByAverageSalary() {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info byAverageSalary", employeeRepo.averageSalary());
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	// Native Query
	@RequestMapping(value="avgSalaryNative", method = RequestMethod.GET)
	public ResponseEntity<Response> findByNativeAverageSalary() {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info byNativeAverageSalary", employeeRepo.nativeAverageSalary());
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	// Native Named Query	[If number of binding/input parameter are more]
	@RequestMapping(value="avgSalaryNativeNamed", method = RequestMethod.GET)
	public ResponseEntity<Response> findByNativeNamedAverageSalary(@RequestParam("name") String name, @RequestParam("mobile") long mobile) {
		
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee info byNativeNamedAverageSalary", employeeRepo.nativeNamedAverageSalary(name, mobile));
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	
	//Update Section
	
	//Modifying/Updating Transactional method
	@RequestMapping(value="updateSalary", method = RequestMethod.POST)
	public ResponseEntity<Response> updateSalary(@RequestParam("id") int id, @RequestParam("salary") float salary) {
		
		employeeRepo.updateSalary(id, salary);
		Response response = new Response(HttpStatus.CREATED.toString(), 
				"Employee salary updated...", new String("updated salary: "+salary));
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
}
