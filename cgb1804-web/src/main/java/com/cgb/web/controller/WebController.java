package com.cgb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    
    @RequestMapping("/index")
    public String showIndex(){
        return "redirect:AdminLTE-2.4.2/index.jsp";
    }
    
}
