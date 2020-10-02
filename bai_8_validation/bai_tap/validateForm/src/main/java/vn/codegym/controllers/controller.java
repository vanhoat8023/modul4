package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.User;
import vn.codegym.service.UserService;

@Controller
@RequestMapping("/user")
public class controller {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable){
        model.addAttribute("userList",userService.findAll(pageable));
        return "/user/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute User user, BindingResult bindingResult ){
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "/user/create";
        }else {
            userService.save(user);
            return "redirect:/user";
        }
    }
}
