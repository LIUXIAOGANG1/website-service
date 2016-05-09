package com.android.website.repositories;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.android.website.beans.SmokeSite;
import com.android.website.utils.JsonTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class SmokeSiteRepositoryTest {

	@Resource
	private SmokeSiteRepository smokeSiteRepository;
	
	@Test
	public void findOne(){
		SmokeSite smokeSite = smokeSiteRepository.findOne("0101");
		String msg = JsonTools.createJsonString("SmokeSite", smokeSite);
		System.out.println(msg);
	}
	
	@Test
	public void findByPollutionName(){
		SmokeSite smokeSite = smokeSiteRepository.findByPollutionName("2#活性出口");
		String msg = JsonTools.createJsonString("SmokeSite", smokeSite);
		System.out.println(msg);
	}
}
