package com.sys.axsos.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sys.axsos.models.LoginUser;
import com.sys.axsos.models.MesComment;
import com.sys.axsos.models.User;
import com.sys.axsos.models.Event;
import com.sys.axsos.repositories.RepoForEvent;
import com.sys.axsos.repositories.RepoForMesComment;
import com.sys.axsos.repositories.RepoForUser;

@Service
public class ServingEvents {
	private final RepoForUser RepU;
	private final RepoForEvent RepE;
	private final RepoForMesComment RepM;

	public ServingEvents(RepoForUser RC, RepoForEvent RT, RepoForMesComment RL) {
		RepU = RC;
		RepE = RT;
		RepM = RL;	
	}

	public List<User> findAllUsers() {
		return RepU.findAll();}

	public User registering(@Valid User diyar, BindingResult result) {
		if (RepU.findByEmail(diyar.getEmail()).isPresent()) {
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
			return RepU.save(diyar);
		}
	}

	public User login(@Valid LoginUser someoneLogging, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<User> potentialUser = RepU.findByEmail(someoneLogging.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}
		User thisExactUser = potentialUser.get();
		if (!BCrypt.checkpw(someoneLogging.getPassword() , thisExactUser.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			return thisExactUser;
		}
	}

	//	    // find user by id
	//	    public User findUserById(Long id) {
	//	    	Optional<User> potentialUser = RepU.findById(id);
	//	    	if(potentialUser.isPresent()) {
	//	            return potentialUser.get();
	//	    	} else {
	//	    	    return null;
	//	    	}
	//	    }
	
	public User gettingUser(Long attributatel) {
		Optional<User> potentialUser = RepU.findById(attributatel);
		return potentialUser.get();}

	public List<Event> getAllEvents() {
		return RepE.findAll();}

	public List<Event> getkolelEventatMish3indak(Long omarna) {
		Optional<User> potentialUser = RepU.findById(omarna);
		User userInThePage = potentialUser.get();
		return RepE.findByStateNotContaining(userInThePage.getState());}
	
	public List<Event> getkolelEventat3indak(Long omarna) {
		Optional<User> potentialUser = RepU.findById(omarna);
		User userInThePage = potentialUser.get();
		return RepE.findByStateContaining(userInThePage.getState());}

	public Event singEvent(Event someEvent, Long usId) {
		someEvent.setHost(gettingUser(usId));
		return RepE.save(someEvent);}
	
	public Event getMeSomeEvent(Long nizaRid) {
		return RepE.findById(nizaRid).get();}

	public void createNewComment(@Valid MesComment commentCreation) {
		System.out.println("inside repo criating in progress");
		RepM.save(commentCreation);System.out.println("Done with repo");}

	public void joinTheEvent(Long id, Long joiningUserID) {
		Event eventToJoin = getMeSomeEvent(id);
		User userToJoin = gettingUser(joiningUserID);
		List<User> usersAttindingEvent = eventToJoin.getUsersAttending();
		usersAttindingEvent.add(userToJoin);
		eventToJoin.setUsersAttending(usersAttindingEvent);
		RepE.save(eventToJoin);}

	public void updateEvent(@Valid Event updatedEvent) {
		Event eventToUpdate = getMeSomeEvent(updatedEvent.getId());
		eventToUpdate.setName(updatedEvent.getName());
		eventToUpdate.setDate(updatedEvent.getDate());
		eventToUpdate.setLocation(updatedEvent.getLocation());
		eventToUpdate.setState(updatedEvent.getState());
		RepE.save(eventToUpdate);}	
	
	public void deleteAnEventById(Long id) {
		RepE.deleteById(id);}

	public void cancelevent(Long id, Long cancellingUserID) {
		Event eventToChange = getMeSomeEvent(id);
		User userToCancel = gettingUser(cancellingUserID);
		List <User> SSD = eventToChange.getUsersAttending();
		SSD.remove(userToCancel);
		eventToChange.setUsersAttending(SSD);
		RepE.save(eventToChange);
	}



	//		public State newstate(@Valid State x) {
	//			System.out.println(x.getName());
	//			return SR.save(x);
	//		}

	//		public void createMessage(@Valid Message message) {
	//			Mr.save(message);
	//			
	//		}
}