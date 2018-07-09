package com.dh.ssiservice.services;

import com.dh.ssiservice.model.Employee;
import com.dh.ssiservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployee() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().iterator().forEachRemaining(employees::add);
        return employees;
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findByFirstName(firstName).get().iterator().forEachRemaining(employee -> {employees.add(employee);});
        return employees;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Optional<Employee> employees ;
        employees = employeeRepository.findById(id);
        return employees;
    }
}
