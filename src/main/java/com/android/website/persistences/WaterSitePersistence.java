package com.android.website.persistences;

import java.util.List;

import com.android.website.beans.WaterSite;

public interface WaterSitePersistence {
	public WaterSite findOne(int id);
	
	public WaterSite findBySite(String site);
	
	public List<WaterSite> findAll();
	
	public List<String> findAllSit();
}
