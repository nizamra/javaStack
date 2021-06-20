package com.sys.axsos.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sys.axsos.UpdateDelete.model.UpdateHere;
import com.sys.axsos.services.service;

@RestController
public class BooksApi {
 private final service service;
 public BooksApi(service bookService){
     this.service = bookService;
 }
 @RequestMapping("/api/books")
 public List<UpdateHere> showAll() {
	 return service.allBooks();
 } 
 @RequestMapping(value="/api/books", method=RequestMethod.POST)
 public UpdateHere create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	 UpdateHere book = new UpdateHere(title, desc, lang, numOfPages);
     return service.createBook(book);
 }
 
 // other methods removed for brevity
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
 public UpdateHere update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	 UpdateHere book = service.updateBook(id, title, desc, lang, numOfPages);
     return book;
 }
 
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
	 service.deleteBook(id);
 }
}