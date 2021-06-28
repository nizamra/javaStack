package com.sys.axsos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.Country;

@Repository
public interface RepoForCountry extends CrudRepository<Country, Long> {
	List<Country> findByCapitalNotNull();
	
	@Query("SELECT c.name, lang.language, lang.percentage "
			+ "FROM Country c "
			+ "JOIN c.languages lang "
			+ "WHERE lang.language IN ('Slovene') "
			+ "ORDER BY lang.percentage DESC")
	List <Object[]> returningSlovene();
	
	@Query("SELECT c.name, COUNT(cc) AS numberOFCities "
			+ "FROM Country c "
			+ "JOIN c.cities cc "
			+ "GROUP BY c.name "
			+ "ORDER BY numberOFCities DESC")
	List <Object[]> returnCities();
	@Query("SELECT c.name, cty.name, cty.population "
			+ "FROM Country c "
			+ "JOIN c.cities cty "
			+ "WHERE c.name IN ('Mexico') "
			+ "AND cty.population > 500000")
	List <String> returnMexCities();
	@Query("SELECT c.name, lang.language "
			+ "FROM Country c "
			+ "JOIN c.languages lang "
			+ "WHERE lang.percentage > 89.0 "
			+ "ORDER BY lang.percentage DESC")
	List <Object[]> returnLangPerc();
//	@Query(value="SELECT c.name, lang.name"
//			+ "FROM Country c "
//			+ "JOIN c.language lang "
//			+ "WHERE lang.percentage > 89.0 "
//			+ "ORDER BY lang.percentage DESC", nativeQuery=true)
//	List <Object[]> returnLangPerc();
}
