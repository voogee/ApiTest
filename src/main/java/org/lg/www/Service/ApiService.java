package org.lg.www.Service;

import org.json.JSONObject;
import org.lg.www.common.HttpUtils;
import org.lg.www.entity.ApiTest;

import java.util.ArrayList;
import java.util.List;


public class ApiService{
    private ApiTest apitest;
    private MailService mailervice;


    public  ApiService(ApiTest apitest){
        String url = "https://" + apitest.getHost() + apitest.getPath() + "?" + apitest.getParameter();
        List jsonpathlist = apitest.getJsonpath();
        String respose = HttpUtils.sendHttpGet(url);
        System.out.println(AssertionService.AsserResult(respose,jsonpathlist));
    }

}


