package com.dev.oneblog.user.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kyeongmin ku
 */

@Slf4j
@AllArgsConstructor
@Controller
//@RestController
@RequestMapping(value="/user")
public class UserController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "hello spring security");
        return "index";
    }
}
