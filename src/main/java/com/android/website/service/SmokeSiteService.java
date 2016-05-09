package com.android.website.service;

import java.util.List;

import com.android.website.beans.SmokeSite;

public interface SmokeSiteService {
	public SmokeSite findOne(String id);
	
	public SmokeSite findByPollutionName(String pollutionName);
	
	public List<SmokeSite> findAll();
}
