package com.sys.axsos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name="countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String continent;
	private String region;
	private Double surface_area;
	private Short indep_year;
	private int population;
	private Double life_expectancy;
	private Double gnp;
	private Double gnp_old;
	private String local_name;
	private String government_form;
	private String head_of_state;
	private int capital;
	private String code2;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<Language> languages;

	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<City> cities;
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	public Country() {}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the continent
	 */
	public String getContinent() {
		return continent;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @return the surface_area
	 */
	public Double getSurface_area() {
		return surface_area;
	}

	/**
	 * @return the indep_year
	 */
	public Short getIndep_year() {
		return indep_year;
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @return the life_expectancy
	 */
	public Double getLife_expectancy() {
		return life_expectancy;
	}

	/**
	 * @return the gnp
	 */
	public Double getGnp() {
		return gnp;
	}

	/**
	 * @return the gnp_old
	 */
	public Double getGnp_old() {
		return gnp_old;
	}

	/**
	 * @return the local_name
	 */
	public String getLocal_name() {
		return local_name;
	}

	/**
	 * @return the government_form
	 */
	public String getGovernment_form() {
		return government_form;
	}

	/**
	 * @return the head_of_state
	 */
	public String getHead_of_state() {
		return head_of_state;
	}

	/**
	 * @return the capital
	 */
	public int getCapital() {
		return capital;
	}

	/**
	 * @return the code2
	 */
	public String getCode2() {
		return code2;
	}

	/**
	 * @return the languages
	 */
	public List<Language> getLanguages() {
		return languages;
	}

	/**
	 * @return the cities
	 */
	public List<City> getCities() {
		return cities;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param continent the continent to set
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @param surface_area the surface_area to set
	 */
	public void setSurface_area(Double surface_area) {
		this.surface_area = surface_area;
	}

	/**
	 * @param indep_year the indep_year to set
	 */
	public void setIndep_year(Short indep_year) {
		this.indep_year = indep_year;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * @param life_expectancy the life_expectancy to set
	 */
	public void setLife_expectancy(Double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	/**
	 * @param gnp the gnp to set
	 */
	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}

	/**
	 * @param gnp_old the gnp_old to set
	 */
	public void setGnp_old(Double gnp_old) {
		this.gnp_old = gnp_old;
	}

	/**
	 * @param local_name the local_name to set
	 */
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	/**
	 * @param government_form the government_form to set
	 */
	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	/**
	 * @param head_of_state the head_of_state to set
	 */
	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(int capital) {
		this.capital = capital;
	}

	/**
	 * @param code2 the code2 to set
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}

	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}