package com.yl.Future;

import java.util.function.Supplier;

/**
 * @author: vaeling.you
 * @create: 2021/7/28
 */
public class OddCombine implements Supplier<Integer> {
    @Override
    public Integer get() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1+3+5+7+9;
    }
}
