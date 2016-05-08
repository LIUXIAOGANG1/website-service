package com.android.website.repositories.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.android.website.repositories.TestRepository;

@Repository
public class TestRepositoryImpl implements TestRepository {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String getInfo(String id) {
//		String Sql = "select Data from Datas where PointerID = '"
//	            + PointerID + "' and CDataID = '" + CDataID + "' and DataDate >= '" + time + "' and DataDate < '" + DateTime.Now + "'";
		
		String sql = "SELECT '检测项目' FROM '烟气_二氧化硫录入' WHERE '编号' = ?";
		
		String result = (String)jdbcTemplate.queryForObject(sql, new Object[] {id},  java.lang.String.class);
		return result;
	}

}
