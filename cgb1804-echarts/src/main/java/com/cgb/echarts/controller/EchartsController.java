package com.cgb.echarts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgb.echarts.pojo.Echarts;
import com.cgb.ehcarts.service.EchartsService;

@Controller
public class EchartsController {
	@Autowired
	private EchartsService echartsService;
	
	@RequestMapping("/line")
	public String doline(){
		return "line-smooth";
	}
	
	@RequestMapping("/pie")
	public String dopie(){
		return "pie-nest";
	}
	
	
	
	@RequestMapping("/echs/{id}")
	@ResponseBody
	public Echarts findEcharts(@PathVariable String id){
		
		return echartsService.findEcharts(id);
	}
	
	
}
