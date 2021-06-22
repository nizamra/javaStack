package com.codingdojo.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.LicenseRepository;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class relationService {
	private final PersonRepository PS;
	private final LicenseRepository LS;

	public relationService(PersonRepository pS,LicenseRepository Ls) {
		PS = pS;
		LS=Ls;
	}
	
	public Person createPerson(Person b) {
		return PS.save(b);
	}

	public List<Person> allPerson() {
		return PS.findAll();
	}

	public List<License> allLicense() {
		
		return LS.findAll();
	}
	public License createLicense(License l) {
		l.setNumber(this.generateLicenseNumber());
		return LS.save(l);
	}
	public int generateLicenseNumber() {
		License l = LS.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		int largestNumber = l.getNumber();
		largestNumber++;
		return (largestNumber);
	}
}
