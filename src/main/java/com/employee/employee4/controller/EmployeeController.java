package com.employee.employee4.controller;


import com.employee.employee4.entity.Departement;
import com.employee.employee4.entity.Employee;
import com.employee.employee4.entity.Riwayatpend;
import com.employee.employee4.service.DepartementService;
import com.employee.employee4.service.RiwayatpendService;
import jakarta.validation.Valid;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.service.EmployeeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
    public class EmployeeController {
    /*

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
    @PostMapping("/employees/submit")
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

     */

    private final EmployeeService employeeService;
    private final DepartementService departementService;
    private final RiwayatpendService riwayatpendService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartementService departementService, RiwayatpendService riwayatpendService){
        this.employeeService = employeeService;
        this.departementService = departementService;
        this.riwayatpendService = riwayatpendService;
    }

    @GetMapping("/employee")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index_employee";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // Create model attribute to bind form data
        Employee employee = new Employee();
        Departement departement = new Departement();
        Riwayatpend riwayatpend = new Riwayatpend();
        model.addAttribute("employee", employee);
        model.addAttribute("departement", departement);
        model.addAttribute("riwayatpend", riwayatpend);
        model.addAttribute("listDepartements", departementService.getAllDepartements());
        model.addAttribute("listRiwayatpends", riwayatpendService.getAllRiwayatpends());
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/showFormEmployeeForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        Departement departement = new Departement();
        Riwayatpend riwayatpend = new Riwayatpend();
        model.addAttribute("employee", employee);
        model.addAttribute("departement",departement);
        model.addAttribute("riwayatpend",riwayatpend);
        model.addAttribute("listDepartements", departementService.getAllDepartements());
        model.addAttribute("listRiwayatpends", riwayatpendService.getAllRiwayatpends());
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @GetMapping("/readEmployee/{id}")
    public String getKaryawanById(@PathVariable Long id, Model model) {
        employeeService.getKaryawanById(id).ifPresent(employee -> model.addAttribute("employee", employee));
        departementService.getDivisiById(id).ifPresent(departement -> model.addAttribute("departement", departement));
        riwayatpendService.getGelarById(id).ifPresent(riwayatpend -> model.addAttribute("riwayatpend", riwayatpend));
        return "read_employee";
    }
}




