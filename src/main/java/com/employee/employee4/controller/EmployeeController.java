package com.employee.employee4.controller;


import jakarta.validation.Valid;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.service.EmployeeService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

    @Controller
    public class EmployeeController {

        private EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        // handler method to handle list employees request
        @GetMapping({"/employees"})
        public String listEmployees(Model model){
            List<EmployeeDto> employees = employeeService.getAllEmployees();
            model.addAttribute("employees", employees);
            return "employees";
        }

        // handler method to handle new employee request
        @GetMapping("/employees/new")
        public String newEmployee(Model model){
            // employee model object to store employee form data
            EmployeeDto employeeDto = new EmployeeDto();
            model.addAttribute("employee", employeeDto);
            return "create_employee";
        }

        // handler method to handle save employee form submit request
        @PostMapping("/employees")
        public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto employee,
                                   BindingResult result,
                                   Model model){
            if(result.hasErrors()){
                model.addAttribute("employee", employee);
                return "create_employee";
            }

            employeeService.createEmployee(employee);
            return "redirect:/employees";
        }

        // handler method to handle edit employee request
        @GetMapping("/employees/{employeeId}/edit")
        public String editEmployee(@PathVariable("employeeId") Long employeeId,
                                   Model model){
            EmployeeDto employee = employeeService.getEmployeeById(employeeId);
            model.addAttribute("employee", employee);
            return "edit_employee";
        }

        // handler method to handle edit employee form submit request
        @PostMapping("/employees/{employeeId}")
        public String updateEmployee(@PathVariable("employeeId") Long employeeId,
                                     @Valid @ModelAttribute("employee") EmployeeDto employeeDto,
                                     BindingResult result,
                                     Model model){
            if(result.hasErrors()){
                model.addAttribute("employee", employeeDto);
                return "edit_employee";
            }
            employeeDto.setId(employeeId);
            employeeService.updateEmployee(employeeDto);
            return "redirect:/employees";
        }

        // Handler method to handle delete employee request
        @GetMapping("/employees/{employeeId}/delete")
        public String deleteEmployee(@PathVariable("employeeId") Long employeeId){
            employeeService.deleteEmployee(employeeId);
            return "redirect:/employees";
        }

        // Handler method to handle view employee request
        @GetMapping("/employees/{employeeId}/view")
        public String viewEmployee(@PathVariable("employeeId") Long employeeId,
                                   Model model){
            EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
            model.addAttribute("employee", employeeDto);
            return "view_employee";
        }
    }
