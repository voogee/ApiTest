package com.voogee.common;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class JsonDiffUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JsonDiffUtil.class);

    public static boolean compareJson(JSONObject expect, JSONObject actual) {
        return compareJson(expect, actual, true, false);
    }

    //sorted参数用于判断数组中json object的顺序是否一致
    public static boolean compareJson(JSONObject expect, JSONObject actual, boolean sorted) {
        return compareJson(expect, actual, true, sorted);
    }

    //reportError参数：遍历json数组时，不匹配的json对象不需要打印error日志，故使用此参数控制
    private static boolean compareJson(JSONObject expect, JSONObject actual, boolean reportError, boolean sorted) {
        if (expect == null || actual == null) {
            throw new RuntimeException("预期结果或返回结果不能为空");
        }
        if (expect.toString().equals(actual.toString())) {
            return true;
        }
        Set<String> keySet = expect.keySet();
        for (String key : keySet) {
            if (!actual.containsKey(key)) {
                if (reportError) {
                    LOG.error("key: {}不存在", key);
                    LOG.info("完整返回数据: {}", actual);
                }
                return false;
            }
            Object o1 = expect.get(key);
            Object o2 = actual.get(key);
            if (!isSameType(o1, o2)) {
                if (reportError) {
                    LOG.error("类型不匹配, key: {}, 预期值: {}, 实际值: {}", key, o1.getClass().getTypeName(), o2.getClass().getTypeName());
                    LOG.info("完整返回数据: {}", actual);
                }
                return false;
            }
            if (o1 instanceof JSONArray) {
                JSONArray ja1 = (JSONArray) o1;
                JSONArray ja2 = (JSONArray) o2;
                if (ja1.size() != ja2.size()) {
                    if (reportError) {
                        LOG.error("json数组长度不匹配, key: {}, 预期值: {}, 实际值: {}", key, o1, o2);
                        LOG.info("完整返回数据: {}", actual);
                    }
                    return false;
                }
                for (int i = 0; i < ja1.size(); i++) {
                    JSONObject jo1 = ja1.getJSONObject(i);
                    for (int j = 0; j < ja2.size(); j++) {
                        JSONObject jo2 = ja2.getJSONObject(j);
                        if (compareJson(jo1, jo2, false, sorted)) {
                            break;
                        }
                        if (j == ja2.size() - 1) {
                            LOG.error("key: {}, json数组中找不到预期的json对象{}", key, jo1);
                            LOG.info("完整返回数据: {}", actual);
                            return false;
                        }
                    }
                }
                if (sorted && !ja1.toString().equals(ja2.toString())) {
                    LOG.error("key: {}, json数组中对象顺序不一致, 预期值: {}, 实际值: {}", key, ja1, ja2);
                    LOG.info("完整返回数据: {}", actual);
                    return false;
                }
            } else if (o1 instanceof JSONObject) {
                if (!compareJson((JSONObject) o1, (JSONObject) o2, true, sorted)) {
                    return false;
                }
            } else {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                //如要校验每个值都一样，开启此代码
//                if (!s1.equals(s2)) {
//                    if (reportError) {
//                        LOG.error("key: {}, 预期值: {}, 实际值: {}", key, o1, o2);
//                        LOG.info("完整返回数据: {}", actual);
//                    }
//                    return false;
//                }
            }
        }
        return true;
    }

    private static boolean isSameType(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        return o1.getClass().getTypeName().equals(o2.getClass().getTypeName());
    }
}

