package com.powermock.testing;

public class MyServiceUtil {

    public String getServiceUrl(String baseUrl) {
        return baseUrl + "/v1/service";
    }

    private String getPrivateServiceUrl(String baseUrl) {
        return baseUrl + "/private/";
    }

    public static String getStaticServiceUrl(String baseUrl) {
        return baseUrl + "/static/v1/service";
    }
}
