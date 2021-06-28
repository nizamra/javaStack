package com.sys.axsos.controllerForCountries;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sys.axsos.services.ServingCountries;

@Controller
public class ControlingAllCountries {
	private final ServingCountries serverOfMyCountries;

	public ControlingAllCountries(ServingCountries habal) {
		serverOfMyCountries = habal;
	}

	@GetMapping("/")
	public String index(Model someModel) {
		List<Object[]> listSloCons = serverOfMyCountries.getSloveneCountries();
		List<Object[]> listCitiesCount = serverOfMyCountries.getCitiesCount();
		List<String> listMexCities = serverOfMyCountries.getMexCities();
		List<Object[]> listLangPerc = serverOfMyCountries.getLangPerc();
		for(Object[] l : listSloCons) {
			someModel.addAttribute("slo1", l[0]);
			someModel.addAttribute("slo2", l[1]);
			someModel.addAttribute("slo3", l[2]);
		}
		someModel.addAttribute("listOfMexCities", listMexCities);
		someModel.addAttribute("listOfSlovene", listSloCons);
		someModel.addAttribute("listOfCities", listCitiesCount);
		someModel.addAttribute("listOfLangPerc", listLangPerc);
		someModel.addAttribute("wholeWorld", serverOfMyCountries.findAllCountries());
		return "home.jsp";
	}

}
