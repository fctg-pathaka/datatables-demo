package com.datatables.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    private ModelAndView mv = null;

    @GetMapping( "/")
    public ModelAndView showHome() {
        LOG.info("inside show method GET......>>>");
        mv = new ModelAndView("home");
        return mv;
    }
}
