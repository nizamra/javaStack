package com.sys.axsos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.Country;

@Repository
public interface RepoForCountry extends CrudRepository<Country, Long> {
	List<Country> findAll();
	@Query(value="SELECT c.name, lang.language, lang.percentage "
			+ "FROM Country c "
			+ "JOIN c.language lang "
			+ "WHERE lang.language IN 'Slovene' "
			+ "ORDER BY lang.percentage DESC", nativeQuery=true)
	List <Object[]> returningSlovene();
	
	@Query(value="SELECT c.name, COUNT(cc) AS numberOFCities "
			+ "FROM Country c "
			+ "JOIN c.cities cc "
			+ "GROUP BY c.name "
			+ "ORDER BY numberOFCities DESC", nativeQuery=true)
	List <Object[]> returnCities();
	@Query(value="SELECT c.name, COUNT(ctys) AS numberOFCities "
			+ "FROM Country c "
			+ "JOIN c.cities ctys "
			+ "WHERE c.name IN ('Mexico') "
			+ "AND ctys.population > 500_000", nativeQuery=true)
	List <String> returnMexCities();
	@Query(value="SELECT c.name, lang.name"
			+ "FROM Country c "
			+ "JOIN c.language lang "
			+ "WHERE lang.percentage > 89.0 "
			+ "ORDER BY lang.percentage DESC", nativeQuery=true)
	List <Object[]> returnLangPerc();
}
