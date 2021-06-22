package com.sys.axsos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sys.axsos.models.Song;
import com.sys.axsos.services.ServicingSong;



@Controller
public class SongControllinger {
 private final ServicingSong songrepositoryinstance;
 
 public SongControllinger(ServicingSong songrepositoryinstance) {
     this.songrepositoryinstance = songrepositoryinstance;
     }
 
 @RequestMapping("")
 public String index(Model model,@ModelAttribute("songinstance") Song songinstance) {
     List<Song> songinstances = songrepositoryinstance.songinstances();
     model.addAttribute("songinstances", songinstances);
//     model.addAttribute("songinstance", new Song()); 
     return "index.jsp";
}
 @RequestMapping(value="", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("songinstance") Song songinstance, BindingResult result) {
	 if (result.hasErrors()) {
		 return "index.jsp";
	 } else {
		 songrepositoryinstance.createsonginstance(songinstance);
		 return "redirect:/";
	 }
 }
 @RequestMapping("/songs/delete/{id}")
 public String destroy(@PathVariable("id") Long id) {
	 songrepositoryinstance.deletesonginstance(id);
	 return "redirect:/";
 }
 
 @RequestMapping("/songs/edit/{id}")
 public String edit(@PathVariable("id") Long id, Model model) {
	 Song songinstance = songrepositoryinstance.findsonginstance(id);
     model.addAttribute("songinstance", songinstance);
     return "edit.jsp";
 }
 @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
 public String update(@Valid @ModelAttribute("songinstance") Song songinstance, BindingResult result) {
     if (result.hasErrors()) {
         return "edit.jsp";
     } else {
    	 songrepositoryinstance.updatesonginstance(songinstance);
         return "redirect:/";
     }
 }
}