package org.lg.www.entity;

import java.util.List;

public class ApiTest {

    private long id;
    private String name;
    private String host;
    private String path;
    private String parameter;
    private List<String> jsonpath;

    public ApiTest(long id, String name, String host, String path, String parameter, List jsonpath) {
        this.id = id;
        this.host = host;
        this.name = name;
        this.path = path;
        this.parameter = parameter;
        this.jsonpath = jsonpath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String email) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String email) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String password) {
        this.path = path;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String name) {
        this.parameter = parameter;
    }

    public List getJsonpath() {
        return jsonpath;
    }

    public void setJsonpath(String name) {
        this.jsonpath = jsonpath;
    }


}