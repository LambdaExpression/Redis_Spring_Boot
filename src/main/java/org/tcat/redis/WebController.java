package org.tcat.redis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Lin on 2016/11/25.
 */
@Controller
@RequestMapping("/web")
public class WebController {


    private final String USER = "USER_IN_SESSION";

    @GetMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        String date = new Date().toString();
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(USER) != null)
            return date + " --- " + session.getAttribute(USER);
        return date;
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request, String account, String password) {
        HttpSession session = request.getSession();
        session.setAttribute(USER, account + password);
        return true;
    }

    @GetMapping("/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(USER);
        return true;
    }

}
