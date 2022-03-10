package com.nessaj.web.portal.handler;

import com.nessaj.web.portal.constant.TemporaryConstant;
import com.nessaj.web.sdk.httpclient.common.constants.StringConstants;
import com.nessaj.web.sdk.httpclient.common.enums.HttpMethod;
import com.nessaj.web.sdk.httpclient.core.HttpResponse;
import com.nessaj.web.sdk.httpclient.core.HttpsRequest;
import com.nessaj.web.sdk.httpclient.core.Sender;
import com.nessaj.web.sdk.httpclient.core.impl.HttpsSender;
import org.apache.http.client.config.RequestConfig;

import java.io.InputStream;
import java.util.LinkedHashMap;

/**
 * @author keming
 * @Date 2022/03/09 23:04
 */
public class DispatcherHandler {

    public static HttpResponse redirectFile2Manager(InputStream inputStream, String fileName) {
        Sender sender = new HttpsSender();
        LinkedHashMap<Object, Object> params = new LinkedHashMap<>();
        params.put(StringConstants.FILENAME_KEY, fileName);
        HttpsRequest request = HttpsRequest.custom()
                .setUrl(TemporaryConstant.MANAGER_UPLOAD_MODULE)
                .setMethod(HttpMethod.POST)
                .setHeader(null)
                .setParams(params)
                .setMultipartData(inputStream)
                .setRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setConnectionRequestTimeout(5000)
                        .setSocketTimeout(5000)
                        .setRedirectsEnabled(true).build())
                .setKeystorePath("E:/Nessaj/ssl/nessaj-keystore.jks").setKeystoreType("jks").setKeystorePassword("Nessaj@123")
                .setTruststorePath("E:/Nessaj/ssl/nessaj-truststore.jks").setTruststoreType("jks").setTruststorePassword("Nessaj@123")
                .build();
        return (HttpResponse) sender.send(request);
    }

}
