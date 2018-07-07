package com.dh.ssiservice.controller;

import com.dh.ssiservice.repository.ContractRepository;
import org.springframework.stereotype.Controller;

@Controller

public class ContractController {
    private ContractRepository contractRepository;


    public ContractController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    /*
    @RequestMapping("/contracts")
    @RequestMapping
    public String getContracts(@RequestParam(value = "code", required = false) String code, Model model) {
        model.addAttribute("contracts", StringUtils.isEmpty(code) ?
                contractRepository.findAll() :
                contractRepository.findByCode(code).get());
        return "contracts";
    }

    @RequestMapping("/{id}")
    public String getContractById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("contract", contractRepository.findById(id).get());
        return "contract";
    }*/
}
