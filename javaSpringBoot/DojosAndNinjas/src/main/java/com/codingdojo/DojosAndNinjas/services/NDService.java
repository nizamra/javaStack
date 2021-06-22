package com.codingdojo.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.repositories.DojoRepository;
import com.codingdojo.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NDService {
	private final NinjaRepository NS;
	private final DojoRepository DS;
	public NDService(NinjaRepository nS, DojoRepository dS) {
		NS = nS;
		DS = dS;
	}
	public Dojo createDojo(Dojo b) {
		return DS.save(b);
	}
	public Ninja createNinja(Ninja b) {
		return NS.save(b);
	}
	public List<Ninja> findAll(Dojo x){
		return NS.findAllByDojo(x);
	}
	public List<Dojo> findAllDojos(){
		return DS.findAll();
	}
	public Dojo findDojoById(long id){
		Optional<Dojo> optionalLanguage = DS.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	public List<Ninja> findAllByDojo(Dojo x) {
		return NS.findAllByDojo(x);
	}
}
