package com.sys.axsos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.UpdateDelete.model.UpdateHere;

@Repository
public interface BookInterfaceRepo extends CrudRepository<UpdateHere, Long>{
 // this method retrieves all the books from the database
 List<UpdateHere> findAll();
  // this method finds books with descriptions containing the search string
 List<UpdateHere> findByDescriptionContaining(String search);
 // this method counts how many titles contain a certain string
 Long countByTitleContaining(String search);
 // this method deletes a book that starts with a specific title
 Long deleteByTitleStartingWith(String search);
}
