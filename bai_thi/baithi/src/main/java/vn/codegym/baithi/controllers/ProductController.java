package vn.codegym.baithi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.baithi.model.Product;
import vn.codegym.baithi.service.ProductService;
import vn.codegym.baithi.service.ProductTypeService;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    ProductTypeService productTypeService;
    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String showListCustomer(@RequestParam(required = false, defaultValue = "") String inputSearch, @RequestParam(required = false, defaultValue = "")
            String key, Model model, @PageableDefault(value = 5) Pageable pageable) {
        if (!inputSearch.equals("")) {
            model.addAttribute("productList", productService.search(inputSearch, key, pageable));
        } else {
            model.addAttribute("productList", productService.findAll(pageable));
        }
        model.addAttribute("productTypeList", productTypeService.findAll());
        model.addAttribute("product", new Product());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProductType", productTypeService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
//            model.addAttribute("product", new Product());
            model.addAttribute("listProductType", productTypeService.findAll());
            return "/create";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("ok", "success!!!");
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        productService.remove(id);
        return "redirect:/home";
    }
}
