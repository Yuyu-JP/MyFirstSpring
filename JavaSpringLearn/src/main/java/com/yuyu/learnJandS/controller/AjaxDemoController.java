package com.yuyu.learnJandS.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AjaxDemoController {

    @PostMapping("/submitData")
    public Map<String, String> handleAjaxRequest(@RequestBody Map<String, String> data) {
        String name = data.get("name");
        
        // Process data
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "! Data received successfully.");

        return response;
    }
}
