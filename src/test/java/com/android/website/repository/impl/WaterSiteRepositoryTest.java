package com.android.website.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.android.website.beans.WaterSite;
import com.android.website.repositories.WaterSiteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class WaterSiteRepositoryTest {
	
	@Resource
	private WaterSiteRepository waterSiteRepository;
	
	@Test
	public void findById(){
		WaterSite result = waterSiteRepository.findById(1);
		System.out.println(result.toString());
	}
	
	@Test
	public void findAll(){
		List<WaterSite> results = (List)waterSiteRepository.findAll();
//		System.out.println(result.toString());
		for(WaterSite result : results){
			System.out.println(result.toString());
		}
	}
}
