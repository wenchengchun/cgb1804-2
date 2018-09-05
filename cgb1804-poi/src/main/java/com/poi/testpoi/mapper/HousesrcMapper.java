package com.poi.testpoi.mapper;

import com.poi.testpoi.pojo.Housesrc;

import java.util.List;

public interface HousesrcMapper {


	List<Housesrc> selectHousesrcs();

	void updateHousesrcByName(Housesrc housesrc);

	void addHousesrc(Housesrc housesrc);

	

	int selectByTitle(String title);




}
