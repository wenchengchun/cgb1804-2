package com.poi.testpoi.service;

import com.poi.testpoi.pojo.Housesrc;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HousesrcService {

	List<Housesrc> selectHousesrcs();


	boolean batchImport(String fileName, MultipartFile file) throws Exception;
}
