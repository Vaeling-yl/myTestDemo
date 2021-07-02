package com.yl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @program: t8t-dcp-crm
 * @description:
 * @author: vaeling.you
 * @create: 2021/2/25
 */
public class Curl {
    public static void main(String[] args) {
        getProjectDetail();
    }

    /**
     * 获取公司下的项目信息
     */
    private static void getProjectDetail() {
        JSONArray data = getHttpPost("https://api.tapd.cn/workspaces/projects?company_id=20076501");
        if (Objects.isNull(data)) {
            return;
        }
        data.forEach(obj -> {
            JSONObject dataObj = JSONObject.parseObject(obj.toString());
            String workspace = dataObj.getString("Workspace");
            JSONObject workspaceObj = JSONObject.parseObject(workspace);
            Project project = JSONObject.toJavaObject(workspaceObj, Project.class);
            System.out.println(project);
        });
    }


    /**
     * java 调用 Curl的方法
     *
     * @param cmd curl命令
     * @return Json数据
     */
    public static String execCurl(String[] cmd) {
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        Process process;
        try {
            process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();
        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;
    }

    //接口调用
    public static JSONArray getHttpPost(String address) {
        String[] cmds = {"curl", "-u", "GU4@cwq6:052835B5-194C-2DC8-CC52-E1F78EFF9365", "" + address + ""};
        //String[] cmds = {"curl", "-H", "Content-Type:application/json", "-X","POST","--data",
        //    ""+requestJson+"",
        //  ""+address+""};
        //命令的空格在jva数组里单个的,必须分开写，不能有空格,
        String responseMsg = execCurl(cmds);
        JSONObject resultJson = JSONObject.parseObject(responseMsg);
        int status = resultJson.getIntValue("status");
        if (status != 1) {
            System.out.println("TAPD接口调用，返回结果异常，直接结束 result:{}" + resultJson);
            return null;
        }
        return resultJson.getJSONArray("data");
    }
}
