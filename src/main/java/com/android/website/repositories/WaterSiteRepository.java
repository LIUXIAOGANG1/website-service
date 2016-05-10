package com.android.website.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.android.website.beans.WaterSite;

public interface WaterSiteRepository extends CrudRepository<WaterSite, Integer>{
	public WaterSite findBySite(String site);
	
	@Query("SELECT site FROM waterSite")
	public List<String> findAllSit();
}
