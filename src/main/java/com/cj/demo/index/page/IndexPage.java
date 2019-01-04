package com.cj.demo.index.page;

import com.cj.demo.sys.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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