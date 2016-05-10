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

import com.android.website.beans.WaterData;
import com.android.website.utils.JsonTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class WaterDataRepositoryTest {
	
	@Resource
	private WaterDataRepository waterDataRepository;
	
	@Test
	public void findOne(){
		WaterData waterData = waterDataRepository.findOne(3653);
		String msg = JsonTools.createJsonString("WaterData", waterData);
		System.out.println(msg);
	}
	
	@Test
	public void findByWaterSiteId(){
		List<WaterData> waterDatas = waterDataRepository.findByWaterSiteId(12);
		String msg = JsonTools.createJsonString("WaterDatas", waterDatas);
		System.out.println(msg);
	}
	
	@Test
	public void findBySiteIdAndTime() throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date start = format.parse("1998-01-01 00:00:00");
		Date end = format.parse("2000-03-09 00:00:00");
		List<WaterData> waterDatas = waterDataRepository.findBySiteIdAndTime(12, start, end, 0);
		String msg = JsonTools.createJsonString("WaterDatas", waterDatas);
		System.out.println(msg);
	}
}
