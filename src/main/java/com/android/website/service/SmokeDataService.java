package com.android.website.service;

import java.util.Date;
import java.util.List;

import com.android.website.beans.SmokeData;

public interface SmokeDataService {
	public SmokeData findone(int id);
	
	public List<SmokeData> findBySmokeSiteId(String smokeSiteId);
	
	public List<SmokeData> findBySiteIdAndTime(String siteId, Date start, Date end);
}
