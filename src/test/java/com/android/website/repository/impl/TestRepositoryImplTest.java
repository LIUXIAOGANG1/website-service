package com.android.website.repository.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.android.website.repositories.TestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class TestRepositoryImplTest {

	@Resource
	private TestRepository testRepository;
	
	@Test
	public void test(){
		String result = testRepository.getInfo("2");
		System.out.println(result);
	}
}
