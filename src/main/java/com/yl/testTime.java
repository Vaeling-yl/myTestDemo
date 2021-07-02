package com.yl;

import cn.hutool.core.date.DatePattern;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: vaeling.you
 * @create: 2021/3/11
 */
public class testTime {

    /* 工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2；*/
    private static final String DATE_API = "http://www.easybots.cn/api/holiday.php";

    /**
     * 判断所给日期为什么类型,
     *
     * @param dateStr 日期 20200404
     * @return 0 工作日, 1 休息日, 2 节假日, -1 为判断出错
     */
    public static int holidayType(String dateStr) {
        Integer result = -1;
        String httpArg = "d=" + dateStr;
        String jsonResult = request(DATE_API, httpArg);
        System.out.println(jsonResult);
        result = Integer.parseInt(jsonResult.replace("\"", "")
                .replace("{", "")
                .replace("}", "")
                .split(":")[1]);
        return result;
    }

    public static Map<String, String> getMoreDaysType(int days) {
        String dateStr = "";
        LocalDate localDate = LocalDate.now();
        String pt = String.valueOf(localDate.minusDays(1)).replace("-", "");
        String datept0 = String.valueOf(localDate.minusDays(days)).replace("-", "");
        for (int i = days; i >= 1; i--) {
            String currdays = String.valueOf(localDate.minusDays(i)).replace("-", "");
            if (i == 1) {
                dateStr = dateStr + currdays;
            } else {
                dateStr = dateStr + currdays + ",";
            }
        }
        System.out.println(dateStr);
        String httpArg = "d=" + dateStr;
        String jsonResult = request(DATE_API, httpArg);
        System.out.println(jsonResult);
        Map<String, String> result = new LinkedHashMap<>();
        String[] arr = jsonResult.replace("\"", "")
                .replace("{", "")
                .replace("}", "")
                .split(",");
        for (String str : arr) {
            String[] elem = str.split(":");
            result.put(elem[0], elem[1]);
        }
        return result;
    }

    /**
     * @param httpUrl :请求接口
     * @param httpArg :参数
     * @return 返回结果
     */
    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

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
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {

        Date date = new Date(1617519337 * 1000L);
        String formatDate = cn.hutool.core.date.DateUtil.format(date, DatePattern.PURE_DATE_PATTERN);
       // return Integer.valueOf(formatDate);
        //long timeStamp = System.currentTimeMillis();
       // SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        //String sd = sdf.format(new Date(1617519337));
       // System.out.println(formatDate);
        System.out.println(holidayType("20210404"));
       // System.out.println(getMoreDaysType(30));
    }
}

