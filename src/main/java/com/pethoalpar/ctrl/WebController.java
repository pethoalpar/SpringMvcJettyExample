package com.pethoalpar.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @RequestMapping(path = "/get/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@PathVariable("name") String name){
        return "Hello "+name;
    }

    @RequestMapping(path = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public String test(){
        return "Success";
    }
}
