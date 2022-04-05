package com.nessaj.portal.controller;

import com.nessaj.portal.constant.PortalConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return PortalConstant.PORTAL_HEALTHCHECK_OK;
    }

}
