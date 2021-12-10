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
        ApiService apiService = new ApiService(apiTest);

    }
}
