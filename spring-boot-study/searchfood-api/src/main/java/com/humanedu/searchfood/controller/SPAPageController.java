package com.humanedu.searchfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SPAPageController {
    @GetMapping("/page/main")
    public ModelAndView pageMain(){
        return new ModelAndView("main");    // main.html 파일로 이동(타임리프 덕분에 jsp를 찾지 않고 html로 찾음)

    }

}
