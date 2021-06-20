package com.sys.axsos;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sys.axsos.UpdateDelete.model.UpdateHere;
import com.sys.axsos.services.service;

@Controller
public class BooksController {
 private final service bookService;
 
 public BooksController(service bookService) {
     this.bookService = bookService;
     }
 
 @RequestMapping("/books")
 public String index(Model model) {
     List<UpdateHere> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "/books/index.jsp";
}
 @RequestMapping("/books/{id}")
 public String showhh(Model model,@PathVariable("id") Long id) {
	 UpdateHere book = bookService.findBook(id);
	 model.addAttribute("book", book);
	 return "/books/show.jsp";
 }
 
 @RequestMapping("/books/new")
 public String newBook(@ModelAttribute("book") UpdateHere book) {
     return "/books/new.jsp";
 }
 @RequestMapping(value="/books", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("book") UpdateHere book, BindingResult result) {
     if (result.hasErrors()) {
         return "/books/new.jsp";
     } else {
         bookService.createBook(book);
         return "redirect:/books";
     }
 }
 
}