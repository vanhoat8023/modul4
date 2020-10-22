package vn.codegym.furama.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furama.model.Customer;
import vn.codegym.furama.service.customer.CustomerService;
import vn.codegym.furama.service.customer_type.CustomerTypeService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping
    public String showListCustomer(@RequestParam(required = false, defaultValue = "") String keyword, Model model,
                                   @PageableDefault(value = 5) Pageable pageable){
        if (!keyword.equals("")){
            model.addAttribute("customerTypeList",customerTypeService.findAll());
            model.addAttribute("customerList", customerService.search(keyword, pageable));
            model.addAttribute("customerAdd", new Customer());
            model.addAttribute("customerEdit", new Customer());
            return "/customer/list";
        }else {
            model.addAttribute("customerTypeList",customerTypeService.findAll());
            model.addAttribute("customerList", customerService.findAll(pageable));
            model.addAttribute("customerAdd", new Customer());
            model.addAttribute("customerEdit", new Customer());
            return "customer/list";
        }
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute("customerAdd") Customer customer, BindingResult bindingResult, Model model,
                                 @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirectAttributes){
//        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.findAll(pageable));
            model.addAttribute("customerEdit", new Customer());
            return "/customer/list";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("ok", "success!!!");
        return "redirect:/customer";
    }
    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute("customerEdit") Customer customer, BindingResult bindingResult, Model model,
                               @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.findAll(pageable));
            model.addAttribute("customerAdd", new Customer());
            return "/customer/list";
        }
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("ok", "success!!!");
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable long id){
        customerService.remove(id);
        return "redirect:/customer";
    }
}
