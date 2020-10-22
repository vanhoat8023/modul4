package vn.codegym.furama.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furama.model.Account;
import vn.codegym.furama.model.Service;
import vn.codegym.furama.service.account.AccountService;
import vn.codegym.furama.service.service.FuServiceService;
import vn.codegym.furama.service.serviceType.ServiceTypeService;

@Controller
public class ServiceController {

    @Autowired
    FuServiceService fuServiceService;

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    AccountService accountService;

    @GetMapping("/home")
    public String home(){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = passwordEncoder.encode("123");
//        accountService.save(new Account("hoat", password, "USER", true));
        return "/home";
    }
    @GetMapping("/service")
    public String showListService(@RequestParam(defaultValue = "") String keyword, Model model, @PageableDefault(value = 5) Pageable pageable){
        if (!keyword.equals("")){
            model.addAttribute("listServiceType", serviceTypeService.findAll());
            model.addAttribute("listService",fuServiceService.search(keyword,pageable));
            model.addAttribute("service",new Service());
            return "/service/list";
        }else{
            model.addAttribute("listServiceType", serviceTypeService.findAll());
            model.addAttribute("listService",fuServiceService.findAll(pageable));
            model.addAttribute("service",new Service());
            return "service/list";
        }
    }
    @GetMapping("/service/create")
    public String showCreate(Model model){
        model.addAttribute("service", new Service());
        model.addAttribute("listServiceType", serviceTypeService.findAll());
        return "/service/create";
    }
    @PostMapping("/service/create")
    public String createService(@ModelAttribute Service service, RedirectAttributes redirectAttributes){
       fuServiceService.save(service);
       redirectAttributes.addFlashAttribute("ok","success!!!");
        return "redirect:/service";
    }
    @GetMapping("/service/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("service", fuServiceService.findById(id));
        model.addAttribute("serviceType", serviceTypeService.findAll());
        return "/service/edit";
    }
    @PostMapping("/service/edit")
    public  String editService(@ModelAttribute Service service, RedirectAttributes redirectAttributes){
        fuServiceService.save(service);
        redirectAttributes.addFlashAttribute("ok","success!!!");
        return "redirect:/service";
    }
    @GetMapping("/service/delete/{id}")
    public String deleteService(@PathVariable long id){
        fuServiceService.remove(id);
        return "redirect:/service";
    }
    @PostMapping("/service/search")
    public ModelAndView searchService(@RequestParam String keyword, Pageable pageable){
        return new ModelAndView("/service/list","listService",fuServiceService.search(keyword, pageable));
    }
}
