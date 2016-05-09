package com.android.website.repositories;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.android.website.beans.WaterSite;
import com.android.website.repositories.WaterSiteRepository;
import com.android.website.utils.JsonTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class WaterSiteRepositoryTest {
	
	@Resource
	private WaterSiteRepository waterSiteRepository;
	
	@Test
	public void findOne(){
		WaterSite result = waterSiteRepository.findOne(1);
		String msg = JsonTools.createJsonString("WaterSite", result);
		System.out.println(msg);
	}
	
	@Test
	public void findAll(){
		@SuppressWarnings("unchecked")
		List<WaterSite> results = (List)waterSiteRepository.findAll();
		String msg = JsonTools.createJsonString("WaterSites", results);
		System.out.println(msg);
	}
	
	@Test
	public void findBySite(){
		WaterSite result = waterSiteRepository.findBySite("焦化外排");
		String msg = JsonTools.createJsonString("WaterSite", result);
		System.out.println(msg);
	}
}
