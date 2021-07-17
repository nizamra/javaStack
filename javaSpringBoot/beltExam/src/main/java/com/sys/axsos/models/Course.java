package com.sys.axsos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="courses")

public class Course {

	@Id
	@GeneratedValue
	private Long id;
	@Size(min=1,max=255, message="Name can not be blank")
	private String name;
	@Size(min=1,max=255, message="Instructor can not be blank")
	private String instructor;
	private int maxPeople;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "guests_courses", 
			joinColumns = @JoinColumn(name = "course_id"), 
			inverseJoinColumns = @JoinColumn(name = "guest_id")
			)
	private List<Guest> guests;

	@OneToMany(mappedBy="course", fetch=FetchType.LAZY)
	private List<Guest> participants;
	public List<Guest> getParticipants() {
		return participants;
	}

	public Course() {}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

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
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * @return the maxPeople
	 */
	public int getMaxPeople() {
		return maxPeople;
	}

	/**
	 * @return the guests
	 */
	public List<Guest> getGuests() {
		return guests;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * @param maxPeople the maxPeople to set
	 */
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	/**
	 * @param guests the guests to set
	 */
	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(List<Guest> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instructor=" + instructor + ", maxPeople=" + maxPeople
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", guests=" + guests + ", participants="
				+ participants + "]";
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


}
