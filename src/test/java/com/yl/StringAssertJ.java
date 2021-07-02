package com.yl;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

/**
 * @Author vaeling.you
 * @Date 2020/12/10
 */
public class StringAssertJ {

    @Test
    public void string_assertions_examples() {
        // 检查：开头结尾和长度
        assertThat("Frodo").startsWith("Fro").endsWith("do").hasSize(5);
        assertThat("Frodo").doesNotStartWith("fro").doesNotEndWith("don");
        // 检查：包含
        assertThat("Frodo").contains("rod").doesNotContain("fro").contains("rod", "Fro");
        // 检查：被包含
        assertThat("Frodo").isSubstringOf("Frodon");
        // 检查：仅包含一次
        assertThat("Frodo").containsOnlyOnce("do");

        // 检查：忽略大小写；长度检查
        assertThat("Frodo").isEqualToIgnoringCase("FROdO").hasSameSizeAs("12345");
        assertThat("Frodo".length()).isGreaterThan("Sam".length());
        assertThat("C-3PO").hasSameSizeAs("R2-D2").hasSize(5);
        // 检查：正则匹配检查
        assertThat("Frodo").matches("..o.o").doesNotMatch(".*d");
        assertThat("Frodo").containsPattern("Fr.d");
        assertThat("Frodo").containsPattern(Pattern.compile("Fr.d"));
        // 检查：空串检查
        assertThat("").isEmpty();
        assertThat("").isNullOrEmpty();
        assertThat("not empty").isNotEmpty();
        // 检查：数字包含检查
        assertThat("3210").containsOnlyDigits();

        // 检查：按顺序检查包含
        // String bookDescription = "{ 'title':'Games of Thrones', 'author':'George Martin'}";
        //assertThat(bookDescription).containsSequence("{", "title", "Games of Thrones", "}");

        // 检查：等于；不等于；或者差值范围
        assertThat(38).isEqualTo(38).isCloseTo(40, within(10));
        assertThat(5.0).isCloseTo(6.0, withinPercentage(20.0));
        assertThat(33).isEqualTo(33).isNotEqualTo(34);

        // 检查： <= < > >=
        assertThat(55).isGreaterThan(44).isGreaterThanOrEqualTo(53);
        assertThat(44).isLessThan(55).isLessThanOrEqualTo(45);
        assertThat(44).isBetween(33, 55);

        // 检查：正数 0 负数
        assertThat(0).isZero();
        assertThat(-1).isNegative();
        assertThat(1).isPositive();

        assertThat(0).isNotNegative();
        assertThat(0).isNotPositive();
        assertThat(1).isNotNegative();
        assertThat(-1).isNotPositive();

        // 检查：数组 顺序检查
        assertThat(new int[]{-1, 2, 3}).contains(-1, 2);
        assertThat(new float[]{1.0f, 2.0f, 3.0f}).containsSubsequence(1.0f, 3.0f);
    }
}
