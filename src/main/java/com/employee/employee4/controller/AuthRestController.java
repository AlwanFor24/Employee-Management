package com.employee.employee4.controller;


import com.employee.employee4.dto.UserDto;
import com.employee.employee4.payload.LoginRestDto;
import com.employee.employee4.service.AuthRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private AuthRestService authRestService;

    public AuthRestController(AuthRestService authRestService) {
        this.authRestService = authRestService;
    }

    //Build login REST API
    @PostMapping(value = {"/login"})
    public ResponseEntity<String> loginrest(@RequestBody UserDto userDto) {
        String response = authRestService.loginrest(userDto);
        return ResponseEntity.ok(response);
    }

}
