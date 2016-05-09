package com.android.website.service;

import java.util.Date;
import java.util.List;

import com.android.website.beans.WaterData;

public interface WaterDataService {
	
	public WaterData findone(int id);
	
	public List<WaterData> findByWaterSiteId(int waterSiteId);
	
	public List<WaterData> findBySiteIdAndTime(int siteId, Date start, Date end);
}
