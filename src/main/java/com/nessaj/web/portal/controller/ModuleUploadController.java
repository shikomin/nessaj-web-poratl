package com.nessaj.web.portal.controller;

import com.nessaj.web.portal.constant.PortalConstant;
import com.nessaj.web.portal.handler.DispatcherHandler;
import com.nessaj.web.sdk.httpclient.core.HttpResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author keming
 * @Date 2022/03/09 11:56
 */
@Controller
public class ModuleUploadController {

    private static final Logger logger = Logger.getLogger(ModuleUploadController.class);

    @PostMapping("/module")
    @ResponseBody
    public String uploadModule(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return PortalConstant.UPLOAD_MODULE_FAILED;
        }

        String fileName = file.getOriginalFilename();
        HttpResponse response = null;
        try {
            response = DispatcherHandler.redirectFile2Manager(file.getInputStream(), fileName);
        } catch (IOException e) {
            logger.error(PortalConstant.REDIRECT_MODULE_FAILED, e);
        }
        if (response != null && response.getStatusLine().equals(PortalConstant.HTTP_STATUS_200))
            logger.info(PortalConstant.REDIRECT_MODULE_SUCCESS);
        else
            logger.info(response.toString());
        return PortalConstant.UPLOAD_MODULE_SUCCESS;
    }

}
