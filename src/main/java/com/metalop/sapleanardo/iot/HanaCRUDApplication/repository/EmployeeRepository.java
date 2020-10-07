package com.metalop.sapleanardo.iot.HanaCRUDApplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.metalop.sapleanardo.iot.HanaCRUDApplication.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}