package com.dh.ssiservice.controller;

import com.dh.ssiservice.repository.PositionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PositionController {
    private PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @RequestMapping("/positions")
    public String getPositions(Model model) {
        model.addAttribute("positions", positionRepository.findAll());
        return "positions";
    }

}
