package com.dh.ssiservice.controller;

import com.dh.ssiservice.repository.EmployeeRepository;
import com.dh.ssiservice.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /* @RequestMapping("/employees")
         public String getEmployees(Model model) {
             model.addAttribute("employees", employeeRepository.findAll());
             return "employees";
         }*/
    @RequestMapping
    public String getEmployees(@RequestParam(value = "firstName", required = false) String firstName, Model model) {
        model.addAttribute("employees", StringUtils.isEmpty(firstName) ?
                employeeService.getEmployee() :
                employeeService.findByFirstName(firstName));
        return "employees";
    }

    @RequestMapping("/{id}")
    public String getEmployeesById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id).get());
        return "employee";
    }

}
