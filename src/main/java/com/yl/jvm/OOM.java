package com.yl.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: vaeling.you
 * @create: 2021/7/14
 */
public class OOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10) ;
        while (true){
            list.add("1") ;
        }
    }
}
