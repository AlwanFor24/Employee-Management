package com.employee.employee4.controller;
import com.employee.employee4.entity.Resign;
import jakarta.validation.Valid;

import com.employee.employee4.dto.ResignDto;
import com.employee.employee4.service.ResignService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resign")
public class ResignController {
    private ResignService resignService;

    public ResignController(ResignService resignService) {
        this.resignService = resignService;
    }

    // handler method to handle list resigns request
    @GetMapping({"/resigns"})
    public String listResigns(Model model){
        List<ResignDto> resigns = resignService.getAllResigns();
        model.addAttribute("resigns", resigns);
        return "resigns";
    }

    // handler method to handle new resign request
    @GetMapping("/resigns/new")
    public String newResign(Model model){
        // resign model object to store resign form data
        ResignDto resignDto = new ResignDto();
        model.addAttribute("resign", resignDto);
        return "create_resign";
    }

    // handler method to handle save resign form submit request
    @PostMapping("/resigns")
    public String saveResign(@Valid @ModelAttribute("resign") ResignDto resign,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("resign", resign);
            return "create_resign";
        }

        resignService.createResign(resign);
        return "redirect:/resigns";
    }

    // handler method to handle edit resign request
    @GetMapping("/resigns/{resignId}/edit")
    public String editResign(@PathVariable("resignId") Long resignId,
                             Model model){
        ResignDto resign = resignService.getResignById(resignId);
        model.addAttribute("resign", resign);
        return "edit_resign";
    }

    // handler method to handle edit resign form submit request
    @PostMapping("/resigns/{resignId}")
    public String updateResign(@PathVariable("resignId") Long resignId,
                               @Valid @ModelAttribute("resign") ResignDto resignDto,
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            model.addAttribute("resign", resignDto);
            return "edit_resign";
        }
        resignDto.setId(resignId);
        resignService.updateResign(resignDto);
        return "redirect:/resigns";
    }

    // Handler method to handle delete resign request
    @GetMapping("/resigns/{resignId}/delete")
    public String deleteResign(@PathVariable("resignId") Long resignId){
        resignService.deleteResign(resignId);
        return "redirect:/resigns";
    }

    // Handler method to handle view resign request
    @GetMapping("/resigns/{resignId}/view")
    public String viewResign(@PathVariable("resignId") Long resignId,
                             Model model){
        ResignDto resignDto = resignService.getResignById(resignId);
        model.addAttribute("resign", resignDto);
        return "view_resign";
    }

    @PostMapping("createFromEmployee/{employeeId}")
    public void createResignFromEmployee(@PathVariable Long employeeId, @RequestBody Resign resign){
        resignService.deleteEmployeeAndCreateResign(employeeId, resign);
    }
}
