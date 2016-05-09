package com.android.website.repositories;

import org.springframework.data.repository.CrudRepository;
import com.android.website.beans.WaterSite;

public interface WaterSiteRepository extends CrudRepository<WaterSite, Integer>{
	public WaterSite findBySite(String site);
}
