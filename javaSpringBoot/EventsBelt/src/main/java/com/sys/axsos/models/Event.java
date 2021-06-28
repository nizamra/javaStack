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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message="firstName is required!")
	@Size(min=3, max=30, message="firstName must be between 3 and 30 characters")
	private String name;

	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;

	@NotEmpty(message="location is required!")
	@Size(min=3, max=30, message="location must be between 3 and 30 characters")
	private String location;

	@NotEmpty
	private String state;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;

	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	private List<MesComment> MesComments;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "attendee", 
			joinColumns = @JoinColumn(name = "event_id"), 
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> usersAttending;

	//    @ManyToOne(fetch = FetchType.LAZY)
	//    @JoinColumn(name="state_id")
	//    private State state;

	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	public Event() {}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
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
	 * @return the host
	 */
	public User getHost() {
		return host;
	}

	/**
	 * @return the mesComments
	 */
	public List<MesComment> getMesComments() {
		return MesComments;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @param host the host to set
	 */
	public void setHost(User host) {
		this.host = host;
	}

	/**
	 * @param mesComments the mesComments to set
	 */
	public void setMesComments(List<MesComment> mesComments) {
		MesComments = mesComments;
	}

	/**
	 * @return the usersAttending
	 */
	public List<User> getUsersAttending() {
		return usersAttending;
	}

	/**
	 * @param usersAttending the usersAttending to set
	 */
	public void setUsersAttending(List<User> usersAttending) {
		this.usersAttending = usersAttending;
	}


}
