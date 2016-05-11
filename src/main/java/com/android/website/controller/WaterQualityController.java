package com.android.website.controller;

import java.util.List;

import javax.annotation.Resource;

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

import com.android.website.beans.WaterData;
import com.android.website.service.WaterService;
import com.android.website.utils.JsonTools;

@Controller
@RequestMapping("/water")
public class WaterQualityController {
	private static final Logger logger = LoggerFactory.getLogger(WaterQualityController.class);

	@Resource
	private WaterService waterService;

	@ResponseBody
	@RequestMapping(value = "/getsamplingsite", method = RequestMethod.POST)
	public ResponseEntity<String> getSamplingSite() {
		logger.info("[WaterQualityController] getSamplingSite() 请求获得水质采样地点。");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);

		List<String> sites = waterService.findAllSit();
		String result = JsonTools.createJsonString("SamplingSites", sites);
		logger.info("[WaterQualityController] getSamplingSite() 准备返回数据:{}", result);

		return new ResponseEntity<String>(result, headers, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getpollutiondata", method = RequestMethod.POST)
	public ResponseEntity<String> getPollutionData(String site, String startTime, String endTime, int page) {
		logger.info("[WaterQualityController] getPollutionData() 通过参数 site: {}, startTime: {}, endTime: {}, page: {} 获取水质污染数据。", site, startTime, endTime, page);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);

		List<WaterData> list = waterService.findByQuery(site, startTime, endTime, page);
		String result = JsonTools.createJsonString("WaterDatas", list);
		logger.info("[WaterQualityController] getPollutionData() 准备返回数据:{}", result);

		return new ResponseEntity<String>(result, headers, HttpStatus.OK);
	}
}
