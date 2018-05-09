package com.zzm.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session, Map<String ,Object> map) {
        if ("111111".equals(password)) {
            session.setAttribute("loginUser",username);
            // 登陆成功，防止表单重复提交  重定向到首页
            return "redirect:/main.html";
        }else{
            map.put("msg","密码错误 登陆失败！");
            return "login";
        }
    }

}
