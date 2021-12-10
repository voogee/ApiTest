package org.lg.www;

import com.jayway.jsonpath.JsonPath;


import org.lg.www.Service.ApiService;
import org.lg.www.common.HttpUtils;
import org.lg.www.entity.ApiTest;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> jsonpathlist = new ArrayList();
        jsonpathlist.add("$.errorCode=1");
        ApiTest apiTest= new ApiTest(1,"测试接口","m139.sy.soyoung.com","/mentorPlatform/actIndexInfo","uid=1714152120&xy_token=7c8306bd3b93f4b0f0a85338efa5f5b8&sys=1&lver=8.38.0&device_id=70178&mentor_id=10171&ab_id=44E4BC3957DC41265FF73548A35C30C7&city_id=0",jsonpathlist);
        ApiService apiService = new ApiService(apiTest);

    }
}
