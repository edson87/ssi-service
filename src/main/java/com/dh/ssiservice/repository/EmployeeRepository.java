package com.dh.ssiservice.repository;

import com.dh.ssiservice.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
