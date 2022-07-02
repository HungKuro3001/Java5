package com.fpoly.java5.controllers;

import com.fpoly.java5.controllers.model.Train;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControllers {
    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String helloRequestParam(@RequestParam String name) {
        if ("".equals(name)) {
            name = "World";
        }
        return "Hello " + name;
    }
    @RequestMapping("/train")
    @ResponseBody
    public Train getTrain() {
        Train train = new Train();
        train.setId("1");
        train.setName("Train pro max");
        return train;
    }
    @RequestMapping("/hello-foward")
    public String helloFoward() {
        return "forward:index.html";
    }
    @RequestMapping("/hello-redirect")
    public String helloRedirect() {
        return "redirect:HelloWorld.html";
    }   
}
