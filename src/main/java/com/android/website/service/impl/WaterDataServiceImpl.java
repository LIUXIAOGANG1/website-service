package com.android.website.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.android.website.beans.WaterData;
import com.android.website.repositories.WaterDataRepository;
import com.android.website.service.WaterDataService;

@Service
public class WaterDataServiceImpl implements WaterDataService {
	private static final Logger logger = LoggerFactory.getLogger(WaterDataServiceImpl.class);
	
	@Resource
	private WaterDataRepository waterDataRepository;

	@Override
	public WaterData findone(int id) {
		logger.info("[WaterDataServiceImpl] findOne 传入参数 id : {}", id);
		WaterData result = waterDataRepository.findOne(id);
		logger.info("[WaterDataServiceImpl] findOne 传入参数 id : {}, 查询结果WaterData为: {}", id, result.toString());
		
		return result;
	}

	@Override
	public List<WaterData> findByWaterSiteId(int waterSiteId) {
		logger.info("[WaterDataServiceImpl] findByWaterSiteId 传入参数 waterSiteId : {}", waterSiteId);
		List<WaterData> lists = waterDataRepository.findByWaterSiteId(waterSiteId);
		logger.info("[WaterDataServiceImpl] findByWaterSiteId 传入参数 waterSiteId : {}, 查询结果List<WaterData>为: {}", waterSiteId, lists);
		
		return lists;
	}

	@Override
	public List<WaterData> findBySiteIdAndTime(int siteId, Date start, Date end) {
		logger.info("[WaterDataServiceImpl] findByWaterSiteId 传入参数 siteId : {}, start: {}, end: {}", siteId, start, end);
		List<WaterData> lists = waterDataRepository.findBySiteIdAndTime(siteId, start, end);
		logger.info("[WaterDataServiceImpl] findByWaterSiteId 传入参数 siteId : {}, start: {}, end: {}, 查询结果List<WaterData>为: {}", siteId, start, end, lists);
		
		return lists;
	}
}
