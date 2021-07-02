package com.yl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: t8t-dcp-crm
 * @description:
 * @author: vaeling.you
 * @create: 2021/2/24
 */
public class test {
    public static void main(String[] args) {
        String[] cmds = {"curl", "-u", "GU4@cwq6:052835B5-194C-2DC8-CC52-E1F78EFF9365",  "https://api.tapd.cn/quickstart/testauth"};
        //String[] cmds = {"curl", "-H", "Content-Type:application/json", "-X","POST","--data",
                //"GU4@cwq6:052835B5-194C-2DC8-CC52-E1F78EFF9365",
               // "https://api.tapd.cn/quickstart/testauth"};
            ProcessBuilder process = new ProcessBuilder(cmds);
            Process p;
            try {
                p = process.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.getProperty("line.separator"));
                }
                System.out.println(builder.toString());

            } catch (IOException e) {
                System.out.print("error");
                e.printStackTrace();
            }
        System.out.println("--");
        }
}
