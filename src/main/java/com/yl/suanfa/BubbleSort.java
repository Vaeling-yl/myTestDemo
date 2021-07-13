package com.yl.suanfa;

/**
 * 冒泡排序
 *
 * @author: vaeling.you
 * @create: 2021/7/2
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr, boolean ascending) { //exchange标志表示为升序排序还是降序排序

         //加一个标志位，记录上一次是否发生了交换，如果是，我们则进行下一轮，如果没有，说明已经冒泡好了
        boolean flag = true;
        for (int i = 1; i < arr.length && flag; i++) {
            //控制次数，第几趟排序，只需要n-1趟，有交换时进行，只有flag=false就说明上一次一个元素都没有进行交换

            /*System.out.print("第"+i+"次遍历：");
            for (int i1 : arr) {
                System.out.print(i1+" ");
            }
            System.out.println();*/

            flag = false; //假定未交换

            for (int j = 0; j < arr.length - i; j++) {
                if (ascending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1]) {
                    //控制升序还是降序
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }

            }
        }
    }

    /**
     *  冒泡排序 -- 默认不传参升序
     */
    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, true);
    }
}
