package com.cj.demo.index.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("index")
public class IndexPage {

    @RequestMapping("getView")
    public String getView(Map<String,Object> map) {
        //map.put("msg", "Hello Freemarker");
        return "index";
    }
}