package vn.codegym.controllers;

import exception.GiveBookBackException;
import exception.RentBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Book;
import vn.codegym.service.BookService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class BookController {
    private Map<Integer, Book> bookMap=new HashMap<>();
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ModelAndView getList(){
        return new ModelAndView("list","books",bookService.getAllBooks());
    }
    @GetMapping("/toRentBook/{id}")
    public ModelAndView viewRentBook(@PathVariable int id) {
        Book book =bookService.getBookById(id);
        Random rand = new Random();
        int random = rand.nextInt(99999- 10000) + 10000;
        if(book==null) {
            return new ModelAndView("error");
        }
        ModelAndView modelAndView= new ModelAndView("rentBook","book",book);
        modelAndView.addObject("random",random);
        return modelAndView;
    }
    @PostMapping("/rentBook/{random}")
    public ModelAndView rentBook(@ModelAttribute Book book, @PathVariable int random) throws RentBookException {
        if(bookService.rentBook(book)) {
            bookMap.put(random, book);
            System.out.println(random);
            return new ModelAndView("list","books",bookService. getAllBooks());
        }
        throw new RentBookException() ;
    }
    @GetMapping("/give_book_back")
    public ModelAndView viewGiveBookBack() {
        return new ModelAndView("giveBookBack","random", new Integer("0"));
    }

    @PostMapping("/give_book_back")
    public ModelAndView giveBookBack(@RequestParam int random) throws GiveBookBackException {
        System.out.println(random);
        if(bookMap.containsKey(random)) {
            Book book= bookMap.get(random);
            bookService.giveBookBack(book);
            bookMap.remove(random);
            return new ModelAndView("list","books",bookService.getAllBooks());
        }
        throw new GiveBookBackException();
    }
}