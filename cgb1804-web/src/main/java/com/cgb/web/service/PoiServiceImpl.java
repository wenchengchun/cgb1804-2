package com.cgb.web.service;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.service.HttpClientService;

@Service
public class PoiServiceImpl implements PoiService{

    @Autowired(required=false)
    private HttpClientService httpClient;
    
    @Override
    public void changeToTestPoi() {
        String url = "poi.cgb.com/index";
        httpClient.get(url);     
    }

}
