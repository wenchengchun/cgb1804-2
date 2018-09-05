package com.cgb.ehcarts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgb.echarts.mapper.EchartsMapper;
import com.cgb.echarts.pojo.Echarts;
@Service
public class EchartsServiceImpl implements EchartsService{
	@Autowired
	private EchartsMapper echartsMapper;
	@Override
	public Echarts findEcharts(String id) {
		
		
		return echartsMapper.findeEcharts(id);
	}


}
