package com.employee.employee4.controller;

import jakarta.validation.Valid;

import com.employee.employee4.dto.RiwayatpendDto;
import com.employee.employee4.service.RiwayatpendService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RiwayatpendController {
    private RiwayatpendService riwayatpendService;

    public RiwayatpendController(RiwayatpendService riwayatpendService) {
        this.riwayatpendService = riwayatpendService;
    }

    // handler method to handle list riwayatpends request
    @GetMapping({"/riwayatpends"})
    public String listRiwayatpends(Model model){
        List<RiwayatpendDto> riwayatpends = riwayatpendService.getAllRiwayatpends();
        model.addAttribute("riwayatpends", riwayatpends);
        return "riwayatpends";
    }

    // handler method to handle new riwayatpend request
    @GetMapping("/riwayatpends/new")
    public String newRiwayatpend(Model model){
        // riwayatpend model object to store riwayatpend form data
        RiwayatpendDto riwayatpendDto = new RiwayatpendDto();
        model.addAttribute("riwayatpend", riwayatpendDto);
        return "create_riwayatpend";
    }

    // handler method to handle save riwayatpend form submit request
    @PostMapping("/riwayatpends")
    public String saveRiwayatpend(@Valid @ModelAttribute("riwayatpend") RiwayatpendDto riwayatpend,
                                  BindingResult result,
                                  Model model){
        if(result.hasErrors()){
            model.addAttribute("riwayatpend", riwayatpend);
            return "create_riwayatpend";
        }

        riwayatpendService.createRiwayatpend(riwayatpend);
        return "redirect:/riwayatpends";
    }

    // handler method to handle edit riwayatpend request
    @GetMapping("/riwayatpends/{riwayatpendId}/edit")
    public String editRiwayatpend(@PathVariable("riwayatpendId") Long riwayatpendId,
                                  Model model){
        RiwayatpendDto riwayatpend = riwayatpendService.getRiwayatpendById(riwayatpendId);
        model.addAttribute("riwayatpend", riwayatpend);
        return "edit_riwayatpend";
    }

    // handler method to handle edit riwayatpend form submit request
    @PostMapping("/riwayatpends/{riwayatpendId}")
    public String updateRiwayatpend(@PathVariable("riwayatpendId") Long riwayatpendId,
                                    @Valid @ModelAttribute("riwayatpend") RiwayatpendDto riwayatpendDto,
                                    BindingResult result,
                                    Model model){
        if(result.hasErrors()){
            model.addAttribute("riwayatpend", riwayatpendDto);
            return "edit_riwayatpend";
        }
        riwayatpendDto.setId(riwayatpendId);
        riwayatpendService.updateRiwayatpend(riwayatpendDto);
        return "redirect:/riwayatpends";
    }

    // Handler method to handle delete riwayatpend request
    @GetMapping("/riwayatpends/{riwayatpendId}/delete")
    public String deleteRiwayatpend(@PathVariable("riwayatpendId") Long riwayatpendId){
        riwayatpendService.deleteRiwayatpend(riwayatpendId);
        return "redirect:/riwayatpends";
    }

    // Handler method to handle view riwayatpend request
    @GetMapping("/riwayatpends/{riwayatpendId}/view")
    public String viewRiwayatpend(@PathVariable("riwayatpendId") Long riwayatpendId,
                                  Model model){
        RiwayatpendDto riwayatpendDto = riwayatpendService.getRiwayatpendById(riwayatpendId);
        model.addAttribute("riwayatpend", riwayatpendDto);
        return "view_riwayatpend";
    }
}
