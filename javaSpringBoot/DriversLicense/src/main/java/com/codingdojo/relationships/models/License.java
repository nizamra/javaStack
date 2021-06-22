package com.codingdojo.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String expirationdate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;

	public License() {	
	}
	public String getNumberAsString() {
		int numZeros = 7 - String.valueOf(this.number).length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numZeros; i++)
			sb.append('0');
		return String.format("%s%d", sb, this.number);
	}



	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public String getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    
    
}