/*
 * Copyright (C) 2011-2021 ShenZhen iBOXCHAIN Information Technology Co.,Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of iBOXCHAIN Company of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with iBOXCHAIN inc.
 *
 *
 */

package com.yl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ok-class
 *
 * @author heshuxuan
 * @date 2021/4/23 17:24
 */
class Ok {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static List<String> bigClassList = new ArrayList<String>();
    private static HashSet<String> bigClassSet = new HashSet<>();
    private static List<String> smallClassList = new ArrayList<String>();
    private static HashSet<String> smallClassSet = new HashSet<>();
    private static List<String> sfList = new ArrayList<String>();
    private static HashSet<String> sfSet = new HashSet<>();
    private static List<String> cityList = new ArrayList<String>();
    private static HashSet<String> citySet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\code\\data\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(1);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        for (int j = 3; j < physicalNumberOfRows; j++) {
            XSSFRow row = sheet.getRow(j);

            save(row, 6, bigClassList, bigClassSet);
            save(row, 7, smallClassList, smallClassSet);
            save(row, 10, sfList, sfSet);
            save(row, 11, cityList, citySet);

        }
        List<String> newBigClassList = bigClassList.stream().distinct().collect(Collectors.toList());

        toTag(bigClassList, "E:\\code\\data\\bigClassList.json");
        toTag(smallClassList, "E:\\code\\data\\smallClassList.json");
        toTag(sfList, "E:\\code\\data\\sfList.json");
        toTag(cityList, "E:\\code\\data\\cityList.json");
    }

    private static void save(XSSFRow row, int i, List<String> tempList, HashSet<String> tempSet) {
        XSSFCell cell = row.getCell(i);
        if (cell != null) {
            String cellValue = cell.getStringCellValue();
            if (!tempSet.contains(cellValue)) {
                tempList.add(cellValue);
                tempSet.add(cellValue);
            }
          
        }
    }

    private static void toTag(List<String> ori, String path) throws IOException {


    }


}
