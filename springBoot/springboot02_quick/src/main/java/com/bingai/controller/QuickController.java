package com.bingai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bingai
 * @create 2020-01-03 11:56
 */
@RestController
public class QuickController {

    @RequestMapping("/quick2")
    public String quick(){
        return "springBoot!!!";
    }

}
