package com.dh.ssiservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller
public class IndexController {

    @GET
    @Path("/{\"\" | / | /index}")
    public String getIndexPage() {
        return "index";
    }
}
