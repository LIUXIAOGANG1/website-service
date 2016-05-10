package com.android.website.persistences.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Persistent;

import com.android.website.beans.SmokeData;
import com.android.website.persistences.SmokeDataPersistence;
import com.android.website.repositories.SmokeDataRepository;

@Persistent
public class SmokeDataPersistenceImpl implements SmokeDataPersistence {
	private static final Logger logger = LoggerFactory.getLogger(SmokeDataPersistenceImpl.class);
	
	@Resource
	private SmokeDataRepository smokeDataRepository;

	@Override
	public SmokeData findone(int id) {
		logger.info("[SmokeDataPersistenceImpl] findOne 传入参数 id : {}", id);
		SmokeData result = smokeDataRepository.findOne(id);
		logger.info("[SmokeDataPersistenceImpl] findOne 传入参数 id : {}, 查询结果SmokeData为: {}", id, result.toString());
		
		return result;
	}

	@Override
	public List<SmokeData> findBySmokeSiteId(String smokeSiteId) {
		logger.info("[SmokeDataPersistenceImpl] findBySmokeSiteId 传入参数 smokeSiteId : {}", smokeSiteId);
		List<SmokeData> lists = smokeDataRepository.findBySmokeSiteId(smokeSiteId);
		logger.info("[SmokeDataPersistenceImpl] findBySmokeSiteId 传入参数 smokeSiteId : {}, 查询结果List<SmokeData>为: {}", smokeSiteId, lists);
		
		return lists;
	}

	@Override
	public List<SmokeData> findBySiteIdAndTime(String siteId, Date start, Date end) {
		logger.info("[SmokeDataPersistenceImpl] findBySiteIdAndTime 传入参数 siteId : {}, start : {}, end : {}", siteId, start, end);
		List<SmokeData> lists = smokeDataRepository.findBySiteIdAndTime(siteId, start, end);
		logger.info("[SmokeDataPersistenceImpl] findBySiteIdAndTime 传入参数 siteId : {}, start : {}, end : {}, 查询结果List<SmokeData>为: {}", siteId, start, end, lists);
		return lists;
	}

}
