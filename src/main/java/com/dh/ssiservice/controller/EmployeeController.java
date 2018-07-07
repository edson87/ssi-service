package com.dh.ssiservice.controller;

import com.dh.ssiservice.repository.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /* @RequestMapping("/employees")
     public String getEmployees(Model model) {
         model.addAttribute("employees", employeeRepository.findAll());
         return "employees";
     }*/
    @RequestMapping
    public String getCategories(@RequestParam(value = "firstName", required = false) String firstName, Model model) {
        model.addAttribute("employees", StringUtils.isEmpty(firstName) ?
                employeeRepository.findAll() :
                employeeRepository.findByFirstName(firstName).get());
        return "employees";
    }

    @RequestMapping("/{id}")
    public String getCategoriesById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return "employee";
    }

}
