package com.yl.phone;

/**
 * @author: vaeling.you
 * @create: 2021/7/12
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(TelephoneUtil.mosaic("15501000110", TelephoneUtil.TelephoneType.Mobile));
        System.out.println(TelephoneUtil.isAlpha("155****0110"));
        System.out.println(TelephoneUtil.format("0938-8499060", TelephoneUtil.TelephoneType.Telephone));
    }
}
