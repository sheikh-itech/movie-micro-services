package com.starter.jpa.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starter.jpa.service.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	//@Query("select e from employee e where e.achievement!=null")
	//public List<Employee> findByAchievement();
}
