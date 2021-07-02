package com.yl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @Author vaeling.you
 * @Date 2020/12/9
 */
class PrivateMethodTestTest {

    @Test
    public void testAdd() throws Exception
    {
        //PrivateMethod pm = new PrivateMethod();
        //获取目标类的class对象
        Class<PrivateMethod> class1 = PrivateMethod.class;

        //获取目标类的实例
        Object instance = class1.newInstance();

        //getDeclaredMethod（）  可获取 公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        //getMethod（） 只可获取公共的方法
        Method method = class1.getDeclaredMethod("add", new Class[]{int.class,int.class});

        //值为true时 反射的对象在使用时 让一切已有的访问权限取消
        method.setAccessible(true);

        Object result = method.invoke(instance, new Object[]{1,2});

        Assert.assertEquals(3, result);

    }

}