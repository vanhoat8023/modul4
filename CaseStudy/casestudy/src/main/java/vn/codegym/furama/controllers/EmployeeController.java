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
import vn.codegym.furama.model.Customer;
import vn.codegym.furama.model.Employee;
import vn.codegym.furama.model.Service;
import vn.codegym.furama.service.employee.EmployeeService;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String showListEmployee(@RequestParam(defaultValue = "") String keyword, Model model, @PageableDefault(value = 5) Pageable pageable){
        if (!keyword.equals("")){
            model.addAttribute("listEmployee",employeeService.search(keyword,pageable));
            model.addAttribute("employee",new Employee());
            return "/employee/list";
        }else{
            model.addAttribute("listEmployee",employeeService.findAll(pageable));
            model.addAttribute("employee",new Employee());
            return "/employee/list";
        }
    }
    @GetMapping("/employee/create")
    public String showCreate(Model model){
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }
    @PostMapping("/employee/create")
    public String createEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        new Customer().validate(employee, bindingResult);
        if (bindingResult.hasErrors()){
            return "/employee/create";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("ok","success!!!");
        return "redirect:/employee";
    }
    @GetMapping("/employee/edit/{id}")
    public String showEdit(@PathVariable long id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/edit";
    }
    @PostMapping("/employee/edit")
    public  String editEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("ok","success!!!");
        return "redirect:/employee";
    }
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable long id){
        employeeService.remove(id);
        return "redirect:/employee";
    }
    @PostMapping("/employee/search")
    public ModelAndView searchEmployee(@RequestParam String keyword, Pageable pageable){
        return new ModelAndView("/employee/list","listEmployee",employeeService.search(keyword, pageable));
    }
}
