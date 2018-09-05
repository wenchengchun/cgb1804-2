package com.cgb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/echarts")
public class EchartsController {

    @RequestMapping("/line")
    public String doline(){
        return "line-smooth";
    }
    
    @RequestMapping("/pie")
    public String dopie(){
        return "pie-nest";
    }
}
