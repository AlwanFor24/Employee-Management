package com.employee.employee4.controller;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.entity.Employee;
import com.employee.employee4.service.EmployeeRestService;
import com.employee.employee4.service.impl.EmployeeRestServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeerestsposts")
/*@ResponseBody*/
public class EmployeeRestController {

    private EmployeeRestService employeeRestService;

    public EmployeeRestController(EmployeeRestService employeeRestService) {
        this.employeeRestService = employeeRestService;
    }

    //create blog post rest api

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeDto> createPost( @RequestBody EmployeeDto employeeDto){
        return  new ResponseEntity<>(employeeRestService.createPost(employeeDto), HttpStatus.CREATED);
    }

    //get all posts rest api
    @GetMapping
    public List<EmployeeDto> getAllPoSTS() {
        return employeeRestService.getAllPosts();
    }


    @GetMapping("/{id}")

    //get employee by id
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name="id")long id){
        return ResponseEntity.ok(employeeRestService.getEmployeeById(id));
    }


    //update employee by id rest api

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmployeeDto> updateEmployee( @RequestBody EmployeeDto employeeDto, @PathVariable(name="id") long id) {

        EmployeeDto employeeResponse = employeeRestService.updateEmployee(employeeDto, id);

        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    //delete employee rest api


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name="id") long id){
        employeeRestService.deleteEmployeeById(id);

        return new ResponseEntity<>("Data Employee berhasil dihapus ", HttpStatus.OK);


    }


}
