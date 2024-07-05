package com.employee.employee4.controller;
import com.employee.employee4.entity.Cuti;
import jakarta.validation.Valid;

import com.employee.employee4.dto.CutiDto;
import com.employee.employee4.service.CutiService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuti")
public class CutiController {
    private CutiService cutiService;

    public CutiController(CutiService cutiService) {
        this.cutiService = cutiService;
    }

    // handler method to handle list cutis request
    @GetMapping({"/cutis"})
    public String listCutis(Model model){
        List<CutiDto> cutis = cutiService.getAllCutis();
        model.addAttribute("cutis", cutis);
        return "cutis";
    }

    // handler method to handle new cuti request
    @GetMapping("/cutis/new")
    public String newCuti(Model model){
        // cuti model object to store cuti form data
        CutiDto cutiDto = new CutiDto();
        model.addAttribute("cuti", cutiDto);
        return "create_cuti";
    }

    // handler method to handle save cuti form submit request
    @PostMapping("/cutis")
    public String saveCuti(@Valid @ModelAttribute("cuti") CutiDto cuti,
                           BindingResult result,
                           Model model){
        if(result.hasErrors()){
            model.addAttribute("cuti", cuti);
            return "create_cuti";
        }

        cutiService.createCuti(cuti);
        return "redirect:/cutis";
    }

    // handler method to handle edit cuti request
    @GetMapping("/cutis/{cutiId}/edit")
    public String editCuti(@PathVariable("cutiId") Long cutiId,
                           Model model){
        CutiDto cuti = cutiService.getCutiById(cutiId);
        model.addAttribute("cuti", cuti);
        return "edit_cuti";
    }

    // handler method to handle edit cuti form submit request
    @PostMapping("/cutis/{cutiId}")
    public String updateCuti(@PathVariable("cutiId") Long cutiId,
                             @Valid @ModelAttribute("cuti") CutiDto cutiDto,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("cuti", cutiDto);
            return "edit_cuti";
        }
        cutiDto.setId(cutiId);
        cutiService.updateCuti(cutiDto);
        return "redirect:/cutis";
    }

    // Handler method to handle delete cuti request
    @GetMapping("/cutis/{cutiId}/delete")
    public String deleteCuti(@PathVariable("cutiId") Long cutiId){
        cutiService.deleteCuti(cutiId);
        return "redirect:/cutis";
    }

    // Handler method to handle view cuti request
    @GetMapping("/cutis/{cutiId}/view")
    public String viewCuti(@PathVariable("cutiId") Long cutiId,
                           Model model){
        CutiDto cutiDto = cutiService.getCutiById(cutiId);
        model.addAttribute("cuti", cutiDto);
        return "view_cuti";
    }

    @PostMapping("createFromEmployee/{employeeId}")
    public void createCutiFromEmployee(@PathVariable Long employeeId, @RequestBody Cuti cuti){
        cutiService.CreateCuti(employeeId, cuti);
    }
}