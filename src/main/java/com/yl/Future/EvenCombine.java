package com.yl.Future;

import java.util.function.Supplier;

/**
 * @author: vaeling.you
 * @create: 2021/7/28
 */
public class EvenCombine implements Supplier<Integer> {
    @Override
    public Integer get() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2+4+6+8+10;
    }
}
