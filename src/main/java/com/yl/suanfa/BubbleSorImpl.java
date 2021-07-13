package com.yl.suanfa;


/**
 * @author: vaeling.you
 * @create: 2021/7/2
 */
public class BubbleSorImpl {
    public static void main(String[] args) {

        int[] nums = {12, 4, 25, 47, 58, 34, 25, 9, 99, 26, 1, -13, 162, 10093, -66, -1};
        int[] temparr;

        //测试冒泡排序
        System.out.println("测试冒泡排序:");
        temparr = nums.clone();
        //BubbleSort.bubbleSort(temparr,true);
        //逆序排序
        BubbleSort.bubbleSort(temparr,false);
        for (int i = 0; i < temparr.length; i++) {
            System.out.print(temparr[i] + " ");
        }
        System.out.println();
    }
}
