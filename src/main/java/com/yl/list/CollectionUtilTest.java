package com.yl.list;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: vaeling.you
 * @create: 2021/7/21
 */
public class CollectionUtilTest {
    public static void main(String[] args) {
        ArrayList<Integer> a = Lists.newArrayList(1, 2, 3, 3, 4, 5);
        ArrayList<Integer> b = Lists.newArrayList(3, 4, 4, 5, 6, 7);

        //要去重，a、b不能为null
        //并集 {1,2,3,3,4,4,5,6,7}
        Collection<Integer> union = CollectionUtils.union(a, b);
        System.out.println(union);

        //(交集)去重: {3,4,5}
        Collection<Integer> intersection = CollectionUtils.intersection(a, b);
        System.out.println(intersection);

        //(交集)未去重：[3, 4, 4, 5]
        Collection<Integer> retainAll = CollectionUtils.retainAll(a, b);
        System.out.println(retainAll);

        //(交集的补集): {1,2,3,4,6,7}
        Collection<Integer> disjunction1 = CollectionUtils.disjunction(a, b);
        System.out.println(disjunction1);
        //(交集的补集): {1,2,3,4,6,7}
        Collection<Integer> disjunction = CollectionUtils.disjunction(b, a);
        System.out.println(disjunction);
        //(A与B的差): {1,2,3}
        Collection<Integer> subtract = CollectionUtils.subtract(a, b);
        System.out.println(subtract);
        //(B与A的差): {4,6,7}
        Collection<Integer> subtract1 = CollectionUtils.subtract(b, a);
        System.out.println(subtract1);
    }
}
