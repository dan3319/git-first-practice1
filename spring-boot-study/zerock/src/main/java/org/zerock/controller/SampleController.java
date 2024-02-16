package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
    @RequestMapping(value= "") // get방식
    public void basic(){
        System.out.println("basic......");
    }

    @RequestMapping(value= "/basic", method = {RequestMethod.GET, RequestMethod.POST}) // get방식
    public void basicGet(){
        System.out.println("basic get......");
    }
    @GetMapping("/basicOnlyGet")
    @RequestMapping(value= "/basicOnlyGet", method = {RequestMethod.GET}) // get방식
    public void basicGet2(){
        System.out.println("basic get only get.....");
    }

    @GetMapping("/basicOnlyPost")
    @RequestMapping(value= "/basicOnlyPost", method = {RequestMethod.POST})
    public void basicPost(){
        System.out.println("basic post only.....");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) { //파라미터값
        System.out.println("sampleDTO:" + dto);

        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name
            , @RequestParam("age") int age) {
        System.out.println("name: " + name);
        System.out.println("age: " + age);

        return "ex02";
    }

    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
        System.out.println("ids: " + ids);

        return "ex02List";
    }

    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) {
        System.out.println("array ids: " + Arrays.toString(ids));

        return "ex02Array";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        System.out.println("ex02Bean: " + list);

        return "ex02Bean";
    }

}
