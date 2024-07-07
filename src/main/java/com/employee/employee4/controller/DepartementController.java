package com.employee.employee4.controller;
import com.employee.employee4.entity.Departement;
import jakarta.validation.Valid;

import com.employee.employee4.service.DepartementService;
import com.employee.employee4.dto.DepartementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartementController {

    /*

    private DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    // handler method to handle list departements request
    @GetMapping({"/departements"})
    public String listDepartements(Model model){
        List<DepartementDto> departements = departementService.getAllDepartements();
        model.addAttribute("departements", departements);
        return "departements";
    }

    // handler method to handle new departement request
    @GetMapping("/departements/new")
    public String newDepartement(Model model){
        // departement model object to store departement form data
        DepartementDto departementDto = new DepartementDto();
        model.addAttribute("departement", departementDto);
        return "create_departement";
    }

    // handler method to handle save departement form submit request
    @PostMapping("/departements")
    public String saveDepartement(@Valid @ModelAttribute("departement") DepartementDto departement,
                                  BindingResult result,
                                  Model model){
        if(result.hasErrors()){
            model.addAttribute("departement", departement);
            return "create_departement";
        }

        departementService.createDepartement(departement);
        return "redirect:/departements";
    }

    // handler method to handle edit departement request
    @GetMapping("/departements/{departementId}/edit")
    public String editDepartement(@PathVariable("departementId") Long departementId,
                                  Model model){
        DepartementDto departement = departementService.getDepartementById(departementId);
        model.addAttribute("departement", departement);
        return "edit_departement";
    }

    // handler method to handle edit departement form submit request
    @PostMapping("/departements/{departementId}")
    public String updateDepartement(@PathVariable("departementId") Long departementId,
                                    @Valid @ModelAttribute("departement") DepartementDto departementDto,
                                    BindingResult result,
                                    Model model){
        if(result.hasErrors()){
            model.addAttribute("departement", departementDto);
            return "edit_departement";
        }
        departementDto.setId(departementId);
        departementService.updateDepartement(departementDto);
        return "redirect:/departements";
    }

    // Handler method to handle delete departement request
    @GetMapping("/departements/{departementId}/delete")
    public String deleteDepartement(@PathVariable("departementId") Long departementId){
        departementService.deleteDepartement(departementId);
        return "redirect:/departements";
    }

    // Handler method to handle view departement request
    @GetMapping("/departements/{departementId}/view")
    public String viewDepartement(@PathVariable("departementId") Long departementId,
                                  Model model){
        DepartementDto departementDto = departementService.getDepartementById(departementId);
        model.addAttribute("departement", departementDto);
        return "view_departement";
    }

     */

    @Autowired
    private DepartementService departementService;

    @GetMapping("/departement")
    public String viewHomePage(Model model) {
        model.addAttribute("listDepartements", departementService.getAllDepartements());
        return "index_departement";
    }

    @GetMapping("/showNewDepartementForm")
    public String showNewDepartementForm(Model model) {
        // Create model attribute to bind form data
        Departement departement = new Departement();
        model.addAttribute("departement", departement);
        return "new_departement";
    }

    @PostMapping("/saveDepartement")
    public String saveDepartement(@ModelAttribute("departement") Departement departement) {
        departementService.saveDepartement(departement);
        return "redirect:/departement";
    }

    @GetMapping("/showFormDepartementForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Departement departement = departementService.getDepartementById(id);
        model.addAttribute("departement", departement);
        return "update_departement";
    }

    @GetMapping("/deleteDepartement/{id}")
    public String deleteDepartement(@PathVariable(value = "id") long id) {
        this.departementService.deleteDepartementById(id);
        return "redirect:/departement";
    }
}

