package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployee();
    List<Employee> findByFirstName(String firstName);
    Optional<Employee> findById(Long id);
}
