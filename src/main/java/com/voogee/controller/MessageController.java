package com.voogee.controller;

import com.alibaba.druid.util.StringUtils;
import com.voogee.bean.Message;
import com.voogee.bean.User;
import com.voogee.service.MessageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;


@Controller
@Scope("prototype")
@RequestMapping("message")
public class MessageController {

    @Resource
    MessageService messageService;


    @PostMapping("msgadd")
    public String message(HttpServletRequest request){
        String parm = request.getParameter("msg");
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");

        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }


        messageService.addmessage(sb.toString());
        return "ok";

    }
}
