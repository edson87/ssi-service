package com.dh.sisteseguridad.controller;

import com.dh.sisteseguridad.services.IncidentRegistryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/incidents")
public class IncidentRegistryController {
    IncidentRegistryService incidentRegistryService;

    public IncidentRegistryController(IncidentRegistryService incidentRegistryService) {
        this.incidentRegistryService = incidentRegistryService;
    }

    @RequestMapping
    public String getIncidents(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("incidentsRegistry", StringUtils.isEmpty(name) ?
                incidentRegistryService.findAll() :
                incidentRegistryService.findByName(name));
        return "incidentsRegistry";
    }

    @RequestMapping("/{id}")
    public String getInventariesById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("incidentRegistry", incidentRegistryService.findById(id));
        return "incidentRegistry";
    }
}
