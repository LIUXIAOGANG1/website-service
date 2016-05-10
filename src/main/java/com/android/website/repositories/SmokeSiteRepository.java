package com.android.website.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.android.website.beans.SmokeSite;

public interface SmokeSiteRepository extends CrudRepository<SmokeSite, String> {
	
	@Query("SELECT DISTINCT(factoryName) FROM smokeSite")
	public List<String> getAllFactory();
	
	
	//@Query("from waterData w where w.waterSiteId = :siteId AND w.samplingTime >= :start AND w.samplingTime <= :end")
	
	@Query("SELECT pollutionName FROM smokeSite s where s.factoryName = :factoryName")
	public List<String> getPollutionByFactory(@Param("factoryName")String factoryName);

	public SmokeSite findByPollutionName(String pollutionName);
}
