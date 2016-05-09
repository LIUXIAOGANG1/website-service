package com.android.website.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.android.website.beans.WaterSite;
import com.android.website.repositories.WaterSiteRepository;
import com.android.website.service.WaterSiteService;

@Service
public class WaterSiteServiceImpl implements WaterSiteService {
	private static final Logger logger = LoggerFactory.getLogger(WaterSiteServiceImpl.class);

	@Resource
	private WaterSiteRepository waterSiteRepository;
	
	@Override
	public WaterSite findOne(int id) {
		logger.info("[WaterSiteServiceImpl] findOne 传入参数 id : {}", id);
		WaterSite result = waterSiteRepository.findOne(id);
		logger.info("[WaterSiteServiceImpl] findOne 传入参数 id : {}, 查询结果WaterSite为: {}", id, result.toString());
		
		return result;
	}
	
	@Override
	public WaterSite findBySite(String site) {
		logger.info("[WaterSiteServiceImpl] findBySite 传入参数 site : {}", site);
		WaterSite result = waterSiteRepository.findBySite(site);
		logger.info("[WaterSiteServiceImpl] findBySite 传入参数 site : {}, 查询结果WaterSite为: {}", site, result.toString());
		
		return result;
	}

	@Override
	public List<WaterSite> findAll() {
		logger.info("[WaterSiteServiceImpl] 调用 findAll()方法");
		List<WaterSite> lists = (List)waterSiteRepository.findAll();
		logger.info("[WaterSiteServiceImpl] findAll 查询结果List<WaterSite>为: {}", lists);
		
		return lists;
	}
}
