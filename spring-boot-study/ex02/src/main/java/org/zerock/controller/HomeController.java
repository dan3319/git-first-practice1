package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/board/list";
    }


    @GetMapping("/board/index.html")
    public String home2() {
        return "redirect:/board/list";
    }

}

