package com.yl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HolidayUtil {
    /**
     * @param httpArg :请求接口
     * @param httpArg :参数
     * @return 返回结果
     */

    public static String request(String httpArg) {
        String httpUrl = "http://tool.bitefu.net/jiari/";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?d=" + httpArg;
        System.out.println(httpUrl);
        try {
            URL url = new URL(httpUrl);

            HttpURLConnection connection = (HttpURLConnection) url

                    .openConnection();

            connection.setRequestMethod("GET");

            connection.connect();

            InputStream is = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String strRead = null;

            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);

            }

            reader.close();

            result = sbf.toString();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return result;

    }

    public static void main(String[] args) {
// 处理节假日
        String httpArg = "20210405";
/*SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");

httpArg = f.format(new Date());*/
        System.out.println(httpArg);
        String jsonResult = HolidayUtil.request(httpArg);

// 0 上班 1周末 2节假日

        if ("0".equals(jsonResult)) {
//return resultObject.getFailResult("上班");

            System.out.println("0上班");

        }

        if ("1".equals(jsonResult)) {
//return resultObject.getFailResult("1周末");

            System.out.println("1周末");

        }

        if ("2".equals(jsonResult)) {
//return resultObject.getFailResult("");

            System.out.println("2节假日");

        }

    }

}