package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/opt")
public class OperationController {
    @RequestMapping("/{jsp}.do")
    public String opt(@PathVariable String jsp){
        return "/" + jsp;
    }


}
