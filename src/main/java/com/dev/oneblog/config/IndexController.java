package com.dev.oneblog.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by kyeongmin ku
 */

@Slf4j
@AllArgsConstructor
@Controller
//@RestController
//@RequestMapping(value="/user")
public class IndexController {

    @GetMapping("/index")
    public String index(Model model, Principal principal) {
        if(principal == null) {
            model.addAttribute("message", "당신은 비회원입니다.");
        } else {
            model.addAttribute("message", "userNmae: " + principal.getName());
        }

        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "info: 누구나 접근");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "userName: " + principal.getName());
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "admin: " + principal.getName());
        return "admin";
    }
}
