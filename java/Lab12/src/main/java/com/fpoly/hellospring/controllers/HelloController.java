package com.fpoly.hellospring.controllers;

import com.fpoly.hellospring.model.Train;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @RequestMapping("/hello/message")
    @ResponseBody
    public String helloSpringMessage() {
        return "Hello " + "-Hoàng Phi Hùng " + "- PH17124";
    }

    @RequestMapping("/hello/view")
    public String helloSpringView() {
        return "hello";
    }

    @GetMapping("/gppd")
    @ResponseBody
    public String getSpringView() {
        Train train = new Train();
        return "GET " + "2" + "-" + "Train pro max plus";
    }

    @PostMapping("/gppd")
    @ResponseBody
    public String postSpringView() {
        Train train = new Train();
        return "POST " + "3" + "-" + "Train pro max plus";
    }

    @PutMapping("/gppd")
    @ResponseBody
    public String putSpringView() {
        Train train = new Train();
        return "PUT " + "4" + "-" + "Train pro max plus";
    }

    @DeleteMapping("/gppd")
    @ResponseBody
    public String deleteSpringView() {
        Train train = new Train();
        return "DELETE " + "5" + "-" + "Train pro max plus";
    }

    @RequestMapping({ "/path-variable/{variable}", "/{variable}/path-variable" })
    @ResponseBody
    public String pathvariable(@PathVariable String variable) {
        if ("".equals(variable))
            return "Chưa có gì";
        else
            return variable;
    }

    @RequestMapping("/requestparam")
    @ResponseBody
    public String requestparam(@RequestParam(name = "name", required = false) String value) {
        return value;
    }


    @RequestMapping("/hello/redirect")
    public String redirect() {
        return "redirect:/about.html";
    }

    @RequestMapping("/hello/forward")
    public String forward() {
        return "forward:/about.html";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestBody Train train) {
        return "hello" + train.getName()+"-"+train.getId();
    }

}
