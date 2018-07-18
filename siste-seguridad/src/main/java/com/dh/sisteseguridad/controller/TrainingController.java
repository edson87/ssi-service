package com.dh.sisteseguridad.controller;

import com.dh.sisteseguridad.services.TrainingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/trainings")
public class TrainingController {
    TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @RequestMapping
    public String getTrainings(@RequestParam(value = "code", required = false) String code, Model model) {
        model.addAttribute("trainings", StringUtils.isEmpty(code) ?
                trainingService.findAll() :
                trainingService.findByCode(code));
        return "trainings";
    }

    @RequestMapping("/{id}")
    public String getTrainingsById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("training", trainingService.findById(id));
        return "training";
    }
}
