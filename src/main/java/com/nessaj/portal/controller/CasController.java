package com.nessaj.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author keming
 * @Date 2022/04/12 17:35
 */
@Controller
public class CasController {

    @RequestMapping("/view")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "redirect:https://cas1.com:8443/cas/logout";
    }

}
