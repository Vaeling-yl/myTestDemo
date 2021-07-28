package com.yl.Future;

import java.util.concurrent.CompletableFuture;

/**
 * @author: vaeling.you
 * @create: 2021/7/28
 */
public class CompletableCombineTest1 {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> oddNumber = CompletableFuture.supplyAsync(new OddCombine());
        CompletableFuture<Integer> evenNumber = CompletableFuture.supplyAsync(new EvenCombine());
        CompletableFuture<Integer> testNumber = CompletableFuture.supplyAsync(new OddNumberPlus());
        long startTime = System.currentTimeMillis();
        CompletableFuture<Void> resultFuturn2 = CompletableFuture.runAsync((Runnable) new OddCombine());

        // 是当第一个执行结束的时候，就结束，后面任务不再等了，可以看作充分条件
        CompletableFuture<Object> resultFuturn = CompletableFuture.anyOf(oddNumber, evenNumber, testNumber);
        System.out.println(resultFuturn.get());
        //可以承受多个CompletableFuture，会等待所有任务都完成。
        CompletableFuture<Void> resultFuturn1 = CompletableFuture.allOf(oddNumber, evenNumber, testNumber);
        System.out.println(resultFuturn1.get());
        System.out.println("0.开始了：" + (System.currentTimeMillis() - startTime) + "秒");


    }
}
