package vn.codegym.controllers;

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
import vn.codegym.model.Library;
import vn.codegym.service.LibraryService;

@Controller
@RequestMapping("library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public String getStudentPage(Model model, @PageableDefault(value = 2) Pageable pageable) {
        model.addAttribute("libraryList", libraryService.findAll(pageable));
        return "/library/list";
    }
    @GetMapping("/create")
    public String createLibrary(Model model){
        model.addAttribute("library",new Library());
        return "/library/create";
    }
    @PostMapping("/create")
    public String createStudent( @ModelAttribute Library library, RedirectAttributes redirectAttributes) {
        libraryService.save(library);
        redirectAttributes.addFlashAttribute("ok", "da dang ki thanh cong");
        return "redirect:/library";
    }
    @GetMapping("borrow/{id}")
    public ModelAndView showBorrow(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/library/borrow");
        Library library = libraryService.findById(id);
        modelAndView.addObject("library", library);
        return modelAndView;
    }
    @PostMapping("/borrow")
    public String deleteLibrary(@ModelAttribute Library library) {
        libraryService.remove(library.getId());
        return "redirect:/library";
    }
    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam String inputSearch, Pageable pageable) {
        return new ModelAndView("/library/list", "libraryList", libraryService.findByBookCode(inputSearch, pageable));
    }
}
