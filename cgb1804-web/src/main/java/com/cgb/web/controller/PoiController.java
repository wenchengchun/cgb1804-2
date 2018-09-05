package com.cgb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgb.web.service.PoiService;
@Controller
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private PoiService poiService;
    
    // http://localhost:9698/service/poi/downloadv1 404 (Not Found)
    @RequestMapping("/downloadv1")
    public String doDownloadv1(){
        poiService.changeToTestPoi();
        return "downloadv1";
    }
    
    @RequestMapping("/downloadv2")
    public String doDownloadv2(){
        return "downloadv2";
    }
    
    
}
