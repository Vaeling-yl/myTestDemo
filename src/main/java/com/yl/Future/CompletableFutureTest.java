package com.yl.Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: vaeling.you
 * @create: 2021/7/28
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final int evenNumber = 2 + 4 + 6 + 8 + 10;
        CompletableFuture<Integer> oddNumber = CompletableFuture.supplyAsync(() -> {
            OddNumberPlus oddNumberPlus = new OddNumberPlus();
            return oddNumberPlus.get();
        }).thenApply(v -> {
                    //thenApply回调（有返回值）  当计算结算完成之后,后面可以接继续一系列的thenApply,来完成值的转化.
                    System.out.println("此时计算结果为：" + (v + 1000000));
                    return v + 1000000;
                }
        );

        try {
            //1.thenAccept回调（无返回值）
            oddNumber.thenAccept(v -> {
                System.out.println("此时计算结果为：" + (evenNumber + v));
            });
            //2.回调
            System.out.println("此时计算结果为：" + (evenNumber + oddNumber.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        CompletableFuture<Integer> oddNumber = CompletableFuture.supplyAsync(new OddNumberPlus());
//        try {
//            Thread.sleep(1000);
//            System.out.println("0.开始了："+ (System.currentTimeMillis()-startTime) +"秒");
//            //看这里，实现回调
//            oddNumber.thenAccept(oddNumberResult->
//            {
//                System.out.println("1.开始了："+ (System.currentTimeMillis()-startTime) +"秒");
//                System.out.println("此时计算结果为："+(evenNumber+oddNumberResult));
//            });
//            oddNumber.get();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}
