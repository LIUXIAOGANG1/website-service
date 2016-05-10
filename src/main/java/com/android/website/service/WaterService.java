package com.android.website.service;

import java.util.List;

import com.android.website.beans.WaterData;

public interface WaterService {
	public List<String> findAllSit();
	
	public List<WaterData> findByQuery(String site, String startTime, String endTime, int page);
}
