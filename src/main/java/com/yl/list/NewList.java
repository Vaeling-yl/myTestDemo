package com.yl.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author: vaeling.you
 * @create: 2021/7/21
 */
public class NewList {

    public static void main(String[] args) {
        //list初始化大小
        Lists.newArrayListWithExpectedSize(100);
        new ArrayList<>();
        Lists.newArrayList();
    }
}
