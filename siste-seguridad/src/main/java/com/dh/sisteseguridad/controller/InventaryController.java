package com.dh.sisteseguridad.controller;

import com.dh.sisteseguridad.model.Inventary;
import com.dh.sisteseguridad.repositories.InventaryRepository;
import com.dh.sisteseguridad.services.GeneralService;
import com.dh.sisteseguridad.services.InventaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/inventaries")
public class InventaryController  {
    InventaryService inventaryService;

    public InventaryController(InventaryService inventaryService) {
        this.inventaryService = inventaryService;
    }

    @RequestMapping
    public String getInventaries(@RequestParam(value = "code", required = false) String code, Model model) {
        model.addAttribute("inventaries", StringUtils.isEmpty(code) ?
                inventaryService.findAll() :
                inventaryService.findByCode(code));
        return "inventaries";
    }

    @RequestMapping("/{id}")
    public String getInventariesById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("inventary", inventaryService.findById(id));
        return "inventary";
    }
}
