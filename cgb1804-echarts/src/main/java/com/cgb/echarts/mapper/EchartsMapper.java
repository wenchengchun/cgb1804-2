package com.cgb.echarts.mapper;

import com.cgb.common.mapper.SysMapper;
import com.cgb.echarts.pojo.Echarts;

public interface EchartsMapper extends SysMapper<Echarts>{

	Echarts findeEcharts(String id);
	
}
