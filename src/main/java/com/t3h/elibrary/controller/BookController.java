package com.t3h.elibrary.controller;

import com.t3h.elibrary.entity.Book;
import com.t3h.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("books", new Book());
        return "book/form";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable(value = "id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("books", book);
        return "book/form";
    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("books") Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "book/form";
        }
        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public ModelAndView getAllListBook() {
        ModelAndView modelAndView =new ModelAndView("listbook");
        modelAndView.addObject("books", bookService.listBook());

        return modelAndView;
    }
}

