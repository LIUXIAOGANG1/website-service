package com.android.website.service.controller;

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

import com.android.website.service.JsonService;
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
        
		JsonService service = new JsonService();
		
		String msg = JsonTools.createJsonString("persons", service.getListPerson());

		logger.info("准备返回数据:{}", msg);
		
		return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    } 
}
