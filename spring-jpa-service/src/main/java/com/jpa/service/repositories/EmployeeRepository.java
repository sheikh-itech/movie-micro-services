package com.jpa.service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.service.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
