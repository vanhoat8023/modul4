package vn.codegym.baithi.cotntrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.baithi.model.Question;
import vn.codegym.baithi.service.QuestionService;
import vn.codegym.baithi.service.QuestionTypeService;
import vn.codegym.baithi.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Autowired
    QuestionTypeService questionTypeService;

    @GetMapping("/home")
    public String showListQuestion(Model model, @RequestParam(required = false, defaultValue = "" ) String keyword) {
        if (!keyword.equals("")) {
            model.addAttribute("listQuestion", questionService.findAll(keyword));
            model.addAttribute("listUser", userService.findAll());
            model.addAttribute("listQuestionType", questionTypeService.findAll());
            return "/list";
        }
            model.addAttribute("listQuestion", questionService.findAll());
            model.addAttribute("listUser", userService.findAll());
            model.addAttribute("listQuestionType", questionTypeService.findAll());
            model.addAttribute("question", new Question());
            return "list";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        model.addAttribute("listQuestionType", questionTypeService.findAll());
        model.addAttribute("listUser", userService.findAll());
        return "/view";
    }

    @GetMapping("/create")
    public String showCreate( Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("listQuestionType", questionTypeService.findAll());
        model.addAttribute("listUser", userService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String createCustomer( @ModelAttribute Question question, Model model,
                                RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            return "/view";
//        }
        questionService.save(question);
        redirectAttributes.addFlashAttribute("ok", "success!!!");
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        model.addAttribute("listQuestionType", questionTypeService.findAll());
        model.addAttribute("listUser", userService.findAll());
        return "/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Question question, RedirectAttributes redirectAttributes) {
        questionService.save(question);
        redirectAttributes.addFlashAttribute("ok", "success!!!");
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        questionService.remove(id);
        return "redirect:/home";
    }
}
