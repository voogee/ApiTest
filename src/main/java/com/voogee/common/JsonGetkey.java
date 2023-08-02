package com.voogee.common;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JsonGetkey {

    @Test
    public void test(){
        String actualstr=  HttpUtils.sendHttpGet("http://152.136.136.83:3000/api/interface/get?token=fff47221d7f29e211c9147069311b372e7a1a757b3e9fa6bd67e16004114c968&id=6");
        String expectstr = "{\"responseData\":{\"lver\":\"\"},\"errorMsg\":\"您的app版本过低，请升级至最新版本!\",\"errorCode\":\"200402623\"}\n";
        JSONObject expectjson = JSONObject.parseObject(expectstr);
        JSONObject actualjson = JSONObject.parseObject(actualstr);
        JSONObject date = actualjson.getJSONObject("data");
        String res_bodystr = date.getString("res_body");
        JSONObject res_bodyjson = JSONObject.parseObject(res_bodystr);

        System.out.println("期望:"+ expectstr);
        System.out.println("实际:"+ res_bodystr);

        boolean result =  JsonDiffUtil.compareJson(expectjson,res_bodyjson);
        System.out.println(result);

    }




    private static Boolean  JsonCompare(JSONObject expect, JSONObject actual) {
        //先取出期望json中的所有的key
        Set<String> set = expect.keySet();
        String[] s=   new String[set.size()];

        //将set装成数组
        s=set.toArray(s);
        for(int i=0;i<s.length;i++){
            if(expect.getString(s[i]).equals("$$")){
                if(actual.getString(s[i]).isEmpty()){
                    System.out.println( actual.getString(s[i])+"不能为空");
                }else continue;
            }else if(expect.getString(s[i]).equals(actual.getString(s[i]))){
                continue;
            }else {
                System.out.println("实际输出："+actual.getString(s[i])+";期望输出："+expect.getString(s[i]));
                return false;

            }
        }
        return true;
    }

}
