package com.codingdojo.DojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.models.Ninja;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long> {
	List <Ninja> findAllByDojo(Dojo x);
}
