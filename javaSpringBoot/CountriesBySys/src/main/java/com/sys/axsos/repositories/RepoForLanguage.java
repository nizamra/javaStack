package com.sys.axsos.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.Language;

@Repository
public interface RepoForLanguage extends CrudRepository<Language, Long> {

}
