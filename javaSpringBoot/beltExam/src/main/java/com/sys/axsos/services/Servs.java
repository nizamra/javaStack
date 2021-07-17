package com.sys.axsos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sys.axsos.models.Course;
import com.sys.axsos.models.Guest;
import com.sys.axsos.models.LoginGuest;
import com.sys.axsos.repositories.CourseRepository;
import com.sys.axsos.repositories.RepositoryForGuest;
import com.sys.axsos.repositories.RoleRepository;

@Service
public class Servs {

	private RoleRepository roleRepository;
	//    private BCryptPasswordEncoder bcrypt;
	private final RepositoryForGuest RU;
	private final CourseRepository cR;

	//	BCryptPasswordEncoder bCryptPasswordEncoder,
	public Servs(RepositoryForGuest ramadan, RoleRepository roleRepos,  CourseRepository cRp) {
		cR = cRp;
		RU = ramadan;
		roleRepository = roleRepos;
		//        bcrypt = bCryptPasswordEncoder;
	}

	public List<Guest> findAllGuests() {
		return RU.findAll();}

	public Guest registering(@Valid Guest diyar, BindingResult result) {
		if (RU.findByEmail(diyar.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		}
		if (!diyar.getPassword().equals(diyar.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			String hashed = BCrypt.hashpw(diyar.getPassword(), BCrypt.gensalt());
			diyar.setPassword(hashed);
			return RU.save(diyar);
		}
	}

	public Guest login(@Valid LoginGuest someoneLogging, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<Guest> potentialGuest = RU.findByEmail(someoneLogging.getEmail());
		if (!potentialGuest.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}
		Guest thisExactGuest = potentialGuest.get();
		if (!BCrypt.checkpw(someoneLogging.getPassword() , thisExactGuest.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			return thisExactGuest;
		}
	}

	public Guest gettingGuest(Long attributatel) {
		Optional<Guest> potentialUser = RU.findById(attributatel);
		return potentialUser.get();}


	public void create(Course newCourse) {
		cR.save(newCourse);
	}

	public ArrayList<Course> all(){
		return (ArrayList<Course>) cR.findAll();
	}
	public ArrayList<Course> alldesending(){
		return (ArrayList<Course>) cR.findAllByOrderByGuestsDesc();
	}
	

	public Course find(Long id) {
		return cR.findById(id).orElse(null);
	}


	public void destroy(Course course) {
		cR.delete(course);
	}

	public Course getMeACourse(Long nizaRid) {
		return cR.findById(nizaRid).get();}

	public void joinTheCourse(long id, Long joiningUserID) {
		Course eventToJoin = getMeACourse(id);
		Guest userToJoin = gettingGuest(joiningUserID);
		List<Guest> usersAttindingEvent = eventToJoin.getGuests();
		usersAttindingEvent.add(userToJoin);
		eventToJoin.setGuests(usersAttindingEvent);
		cR.save(eventToJoin);}

	public void updateCourse(@Valid Course updatedEvent) {
		Course eventToUpdate = getMeACourse(updatedEvent.getId());
		eventToUpdate.setName(updatedEvent.getName());
		eventToUpdate.setInstructor(updatedEvent.getInstructor());
		eventToUpdate.setMaxPeople(updatedEvent.getMaxPeople());
		cR.save(eventToUpdate);}

	public void removeuser(long id, Long joiningUserID) {
		Course eventToJoin = getMeACourse(id);
		Guest userToJoin = gettingGuest(joiningUserID);
		List<Guest> usersAttindingEvent = eventToJoin.getGuests();
		usersAttindingEvent.remove(userToJoin);
		eventToJoin.setGuests(usersAttindingEvent);
		cR.save(eventToJoin);}

}
