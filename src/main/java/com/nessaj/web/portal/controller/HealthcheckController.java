package com.nessaj.web.portal.controller;

import com.nessaj.web.portal.constant.PortalConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return PortalConstant.PORTAL_HEALTHCHECK_OK;
    }

}
