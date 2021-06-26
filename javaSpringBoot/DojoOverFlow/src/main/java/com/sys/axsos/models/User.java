package com.sys.axsos.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	/*
    passwd is the hashed password for each user
    status: tha status of the user if active or deleted
    privilage: numbers from 0superAdmin 1admin 7privilagedUser 8staged  9ordinary user is the default
    cv: the pdf C.V
    profilePic: an image of the user
    mobile: mobile number for contacting
    */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String about;
	private String email;
	private String passwd;
	private String planePassword;
	
//  #059_813_521_321
	private String mobile;
//	locationChoices=(('Ramallah', 'Ramallah'),('Hebron','Hebron'),('Nablus','Nablus'),('Jenin','Jenin'),('Bethlehem','Bethlehem'))
	private String location;
//	genderChoices=(('m', 'm'),('f','f'))
	private Character gender;
//	privilageChoices=((9, 9),(8,8),(7,7),(1,1),(0,0))
	private Byte privilage;
//	statusChoices=(('active', 'active'),('deleted','deleted'),('inactive','inactive'),('Suspended','Suspended'))
	private String status;
//	cv = models.FileField(upload_to='uploads/%Y%m%d', max_length=254, null=True)#pdf files nullable
//	profilePic = models.ImageField(upload_to='images/', null=True)#image of teacher nullable
    
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private Date birthDate;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM-dd-yyyy")
    private Date createdAt;
	@DateTimeFormat(pattern="MM-dd-yyyy")
    private Date updatedAt;

	public User() {
		super();
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
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
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @return the planePassword
	 */
	public String getPlanePassword() {
		return planePassword;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @return the gender
	 */
	public Character getGender() {
		return gender;
	}
	/**
	 * @return the privilage
	 */
	public Byte getPrivilage() {
		return privilage;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @param about the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @param planePassword the planePassword to set
	 */
	public void setPlanePassword(String planePassword) {
		this.planePassword = planePassword;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Character gender) {
		this.gender = gender;
	}
	/**
	 * @param privilage the privilage to set
	 */
	public void setPrivilage(Byte privilage) {
		this.privilage = privilage;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}
