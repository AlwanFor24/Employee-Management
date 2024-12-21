package com.employee.employee4.controller;

import com.employee.employee4.dto.EmployeeDto;
import com.employee.employee4.service.EmployeeRestService;
import com.employee.employee4.service.impl.EmployeeRestServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EmployeeDto> createPost(@RequestBody EmployeeDto employeeDto){
        return  new ResponseEntity<>(employeeRestService.createPost(employeeDto), HttpStatus.CREATED);
    }

    //get all posts rest api
    @GetMapping
    public List<EmployeeDto> getAllPoSTS() {
        return employeeRestService.getAllPosts();
    }

    @GetMapping("api/{id}")

    //get employee by id
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name="id")long id){
        return ResponseEntity.ok(employeeRestService.getEmployeeById(id));
    }


}
