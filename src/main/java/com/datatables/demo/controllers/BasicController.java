package com.datatables.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public ModelAndView handleError(HttpServletRequest request) {
        return new ModelAndView("default");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
