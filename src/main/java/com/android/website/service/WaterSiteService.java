package com.android.website.service;

import java.util.List;

import com.android.website.beans.WaterSite;

public interface WaterSiteService {
	public WaterSite findOne(int id);
	
	public WaterSite findBySite(String site);
	
	public List<WaterSite> findAll();
}
