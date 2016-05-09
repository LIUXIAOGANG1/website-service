package com.android.website.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.android.website.beans.SmokeSite;
import com.android.website.repositories.SmokeSiteRepository;
import com.android.website.service.SmokeSiteService;

@Service
public class SmokeSiteServiceImpl implements SmokeSiteService {
	private static final Logger logger = LoggerFactory.getLogger(SmokeSiteServiceImpl.class);

	@Resource
	private SmokeSiteRepository smokeSiteRepository;
	
	@Override
	public SmokeSite findOne(String id) {
		logger.info("[SmokeSiteServiceImpl] findOne 传入参数 id : {}", id);
		SmokeSite result = smokeSiteRepository.findOne(id);
		logger.info("[SmokeSiteServiceImpl] findOne 传入参数 id : {}, 查询结果SmokeSite为: {}", id, result.toString());
		
		return result;
	}

	@Override
	public SmokeSite findByPollutionName(String pollutionName) {
		logger.info("[SmokeSiteServiceImpl] findByPollutionName 传入参数 pollutionName : {}", pollutionName);
		SmokeSite result = smokeSiteRepository.findByPollutionName(pollutionName);
		logger.info("[SmokeSiteServiceImpl] findOne 传入参数 pollutionName : {}, 查询结果SmokeSite为: {}", pollutionName, result.toString());
		
		return result;
	}

	@Override
	public List<SmokeSite> findAll() {
		logger.info("[SmokeSiteServiceImpl] 调用方法findAll()");
		List<SmokeSite> lists = (List<SmokeSite>)smokeSiteRepository.findAll();
		logger.info("[SmokeSiteServiceImpl] 调用方法findAll() 查询结果List<SmokeSite>为: {}", lists);
		return lists;
	}

}
