package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping
    public ModelAndView showProduct(){
        return new ModelAndView("/product/list","listProduct",productService.findAll());
    }
    @GetMapping("/add")
    public ModelAndView showCreatePage(){
        return new ModelAndView("product/create", "product", new Product());
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetailPage(@PathVariable long id) {
        return new ModelAndView("product/detail","product", productService.findById(id));
    }
}
