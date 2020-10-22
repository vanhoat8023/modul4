package vn.codegym.furama.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furama.model.Contract;
import vn.codegym.furama.service.contract.ContractService;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping
    public String showListContract(@RequestParam(defaultValue = "") String keyword, Model model, @PageableDefault(value = 5) Pageable pageable){
        if (!keyword.equals("")){
            model.addAttribute("listContract",contractService.search(keyword,pageable));
            model.addAttribute("contract",new Contract());
            return "/contract/list";
        }else{
            model.addAttribute("listContract",contractService.findAll(pageable));
            model.addAttribute("contract",new Contract());
            return "/contract/list";
        }
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("contract", new Contract());
        return "/contract/create";
    }
    @PostMapping("/create")
    public String createContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        new Customer().validate(employee, bindingResult);
        if (bindingResult.hasErrors()){
            return "/contract/create";
        }
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("ok","success!!!");
        return "redirect:/contract";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable long id, Model model){
        model.addAttribute("contract", contractService.findById(id));
        return "/contract/edit";
    }
    @PostMapping("/edit")
    public  String editContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("ok","success!!!");
        return "redirect:/contract";
    }
    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable long id){
        contractService.remove(id);
        return "redirect:/contract";
    }
    @PostMapping("/search")
    public ModelAndView searchContract(@RequestParam String keyword, Pageable pageable){
        return new ModelAndView("/contract/list","contract",contractService.search(keyword, pageable));
    }
}
