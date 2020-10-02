package vn.codegym.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.demo.model.AddressCustomer;
import vn.codegym.demo.model.Customer;
import vn.codegym.demo.service.AddressCustomerService;
import vn.codegym.demo.service.CustomerService;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AddressCustomerService addressCustomerService;

    @GetMapping
    public String showList(@RequestParam(required = false, defaultValue = "") String inputSearch,@RequestParam(required = false, defaultValue = "") String key, Model model, @PageableDefault(value = 5) Pageable pageable) {
        if (!inputSearch.equals("")) {
            model.addAttribute("customerList", customerService.search(inputSearch, key, pageable));
            model.addAttribute("search", inputSearch);
            model.addAttribute("keySearch", key);
        } else {
            List<AddressCustomer> addressCustomers = addressCustomerService.findAll();
            model.addAttribute("customerList", customerService.findAll(pageable));
            model.addAttribute("listAddress", addressCustomers);
        }

        model.addAttribute("customer", new Customer());
        return "/customer/list";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Customer customer, BindingResult bindingResult,Model model,@PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirectAttributes) {
        new Customer().validate(customer, bindingResult);
        if(bindingResult.hasErrors()){
            List<AddressCustomer> addressCustomers = addressCustomerService.findAll();
            model.addAttribute("customerList", customerService.findAll(pageable));
            model.addAttribute("listAddress", addressCustomers);
            model.addAttribute("customer", new Customer());
            return "/customer/list";
        }else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("ok", "success");
            return "redirect:/customer";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        List<AddressCustomer> addressCustomers = addressCustomerService.findAll();
        modelAndView.addObject("customer", customerService.findById(id));
        modelAndView.addObject("listAddress", addressCustomers);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer) {
        customerService.update(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customer";
    }

}
