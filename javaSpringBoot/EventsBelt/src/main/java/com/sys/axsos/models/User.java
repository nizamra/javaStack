package com.sys.axsos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message="firstName is required!")
	@Size(min=3, max=30, message="firstName must be between 3 and 30 characters")
	private String firstName;

	@NotEmpty(message="lastName is required!")
	@Size(min=3, max=30, message="lastName must be between 3 and 30 characters")
	private String lastName;

	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;

	@NotEmpty(message="location is required!")
	@Size(min=3, max=30, message="location must be between 3 and 30 characters")
	private String location;

	@NotEmpty
	private String state;

	@NotEmpty(message="Password is required!")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	private String password;

	@Transient
	@NotEmpty(message="Confirm Password is required!")
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	private String confirm;

	@OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	private List<Event> events;

	@OneToMany(mappedBy="writer", fetch = FetchType.LAZY)
	private List<MesComment> mesComments;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "attendee", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "event_id")
			)
	private List<Event> attendingEvents;

	//    @ManyToOne(fetch = FetchType.LAZY)
	//    @JoinColumn(name="state_id")
	//    private State state;

	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	public User() {}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the confirm
	 */
	public String getConfirm() {
		return confirm;
	}

	/**
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param confirm the confirm to set
	 */
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	/**
	 * @return the mesComments
	 */
	public List<MesComment> getMesComments() {
		return mesComments;
	}

	/**
	 * @param mesComments the mesComments to set
	 */
	public void setMesComments(List<MesComment> mesComments) {
		this.mesComments = mesComments;
	}

	/**
	 * @return the attendingEvents
	 */
	public List<Event> getAttendingEvents() {
		return attendingEvents;
	}

	/**
	 * @param attendingEvents the attendingEvents to set
	 */
	public void setAttendingEvents(List<Event> attendingEvents) {
		this.attendingEvents = attendingEvents;
	}



}