package com.sys.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sys.axsos.UpdateDelete.model.UpdateHere;
import com.sys.axsos.repositories.BookInterfaceRepo;

@Service
public class service {
    // adding the book repository as a dependency
    private final BookInterfaceRepo bookRepository;
    
    public service(BookInterfaceRepo bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<UpdateHere> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public UpdateHere createBook(UpdateHere b) {
        return bookRepository.save(b);
    }
    
    public UpdateHere updateBook(Long id, String title, String desc, String lang,Integer numOfPages) {
    	UpdateHere changable = findBook(id);
    	changable.setTitle(title);
    	changable.setDescription(desc);
    	changable.setLanguage(lang);
    	changable.setNumberOfPages(numOfPages);
    	return bookRepository.save(changable);
    }
    public UpdateHere updateBook(UpdateHere b) {
    	UpdateHere changthis = findBook(b.getId());
    	changthis.setTitle(b.getTitle());
    	changthis.setDescription(b.getDescription());
    	changthis.setLanguage(b.getLanguage());
    	changthis.setNumberOfPages(b.getNumberOfPages());
    	return bookRepository.save(changthis);
    }
//    public Book updateBook(Book b) {
//    	Book changethisbook = findBook(b.getId());
//    	changethisbook.setTitle(b.getTitle());
//    	changethisbook.setDescription(b.getDescription());
//    	changethisbook.setLanguage(b.getLanguage());
//    	changethisbook.setNumberOfPages(b.getNumberOfPages());
//    	return bookRepository.save(changethisbook);
//    }
    
    public void deleteBook(Long id) {
		bookRepository.deleteById(id);
    }
    
    // retrieves a book
    public UpdateHere findBook(Long id) {
        Optional<UpdateHere> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}