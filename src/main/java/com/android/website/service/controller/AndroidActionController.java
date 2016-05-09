package com.android.website.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.android.website.beans.Person;
import com.android.website.utils.JsonTools;

@Controller
@RequestMapping("/android")
public class AndroidActionController {
	private static final Logger logger = LoggerFactory.getLogger(AndroidActionController.class);

	@ResponseBody
    @RequestMapping(value = "/getdata", method = RequestMethod.POST)
    public ResponseEntity<String> getData(String info){
        logger.info("请求参数为 id:{}", info);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        
		String msg = JsonTools.createJsonString("persons", getListPerson());

		logger.info("准备返回数据:{}", msg);
		
		return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    } 
	
	public static List<Person> getListPerson() {
		List<Person> list = new ArrayList<Person>();
		Person person1 = new Person(1001, "AHuier1", "Beijing");
		Person person2 = new Person(1002, "AHuier2", "shenzheng");
		list.add(person1);
		list.add(person2);
		return list;
	}
}
