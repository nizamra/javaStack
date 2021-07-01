package com.sys.axsos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.axsos.models.Country;
import com.sys.axsos.repositories.RepoForCity;
import com.sys.axsos.repositories.RepoForCountry;
import com.sys.axsos.repositories.RepoForLanguage;

@Service
public class ServingCountries {
	private final RepoForCountry RepFC;
	private final RepoForCity RepFCT;
	private final RepoForLanguage RepFL;

	

	public ServingCountries(RepoForCountry RC, RepoForCity RT, RepoForLanguage RL) {
		RepFC = RC;
		RepFCT = RT;
		RepFL = RL;	
	}

	public List<Country> findAllCountries() {
		return RepFC.findAll();
		
	}
	public List<Object[]> getSloveneCountries() {
		return RepFC.returningSlovene();
	}
	public List<Object[]> getCitiesCount() {
		return RepFC.returnCities();
	}
	public List<String> getMexCities() {
		return RepFC.returnMexCities();
	}
	public List<Object[]> getLangPerc() {
		return RepFC.returnLangPerc();
	}
	

}
