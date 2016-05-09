package com.android.website.repositories;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.android.website.beans.SmokeData;
import com.android.website.utils.JsonTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class SmokeDataRepositoryTest {
	
	@Resource
	private SmokeDataRepository smokeDataRepository;
	
	@Test
	public void findBySmokeSiteId(){
		List<SmokeData> smokeDatas = smokeDataRepository.findBySmokeSiteId("0103");
		String msg = JsonTools.createJsonString("WaterDatas", smokeDatas);
		System.out.println(msg);
	}
	
	@Test
	public void findBySiteIdAndTime() throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date start = format.parse("2003-01-06 00:00:00");
		Date end = format.parse("2003-11-04 00:00:00");
		List<SmokeData> smokeDatas = smokeDataRepository.findBySiteIdAndTime("0103", start, end);
		String msg = JsonTools.createJsonString("SmokeData", smokeDatas);
		System.out.println(msg);
	}
}
