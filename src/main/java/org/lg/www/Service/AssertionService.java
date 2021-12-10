package org.lg.www.Service;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class AssertionService {
    private JSONObject jsonstring;
    private ArrayList arraylist;
    enum asserttyoe {
        keyassert,listassert,valueassert
    }


    public static JSONObject AsserResult(String resepose, List jsonpathlist){
        String stringresult = "{\"is_success\": false, \"errormsg\":\"\"}";
        JSONObject result = new JSONObject(stringresult);
        int errorcode = JsonPath.read(resepose,"$.errorCode");
        String errormsg = JsonPath.read(resepose,"$.errorMsg");
        if (errorcode != 0) {
            result.put("errormsg", "errormsg=" + errormsg);
            return result;
        }

        try {

            return result;

        }
        catch (Exception e){

            System.out.println(e);
        }
        return result;
    }

}
