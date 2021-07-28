package com.yl.Future;

import java.util.concurrent.CompletableFuture;

/**
 * @author: vaeling.you
 * @create: 2021/7/28
 */
public class CompletableCombineTest {
    public static void main(String[] args) throws Exception {

        Integer oddNumber1 = CompletableFuture.supplyAsync(() -> {
            OddCombine oddCombine = new OddCombine();
            return oddCombine.get();
        }).thenCombine(
                CompletableFuture.supplyAsync(() -> {
                    EvenCombine evenCombine = new EvenCombine();
                    return evenCombine.get();
                }), (oddCombine, evenCombine) -> {
                    return oddCombine + evenCombine;
                }
        ).thenCombine(
                CompletableFuture.supplyAsync(() -> {
                    EvenCombine evenCombine = new EvenCombine();
                    return evenCombine.get();
                }), (oddCombine, evenCombine) -> {
                    System.out.println(oddCombine +"+"+evenCombine);
                    return oddCombine + evenCombine;
                }
        ).join();
        System.out.println(oddNumber1);

        CompletableFuture<Integer> oddNumber = CompletableFuture.supplyAsync(new OddCombine());
        CompletableFuture<Integer> evenNumber = CompletableFuture.supplyAsync(new EvenCombine());
        long startTime = System.currentTimeMillis();
        CompletableFuture<Integer> resultFuturn = oddNumber.thenCombine(evenNumber, (odd, even) -> {
            return odd + even;
        });
        System.out.println(resultFuturn.get());
        System.out.println("0.开始了：" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}