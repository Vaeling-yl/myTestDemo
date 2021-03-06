package com.yl;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;

/**
 * @author: vaeling.you
 * @create: 2021/6/29
 */
public class LocalDate {
    public static void testClock() throws InterruptedException {
        //时钟提供给我们用于访问某个特定 时区的 瞬时时间、日期 和 时间的。
        Clock c1 = Clock.systemUTC(); //系统默认UTC时钟(当前瞬时时间 System.currentTimeMillis())
        System.out.println(c1.millis()); //每次调用将返回当前瞬时时间(UTC)
        Clock c2 = Clock.systemDefaultZone(); //系统默认时区时钟(当前瞬时时间)
        Clock c31 = Clock.system(ZoneId.of("Europe/Paris")); //巴黎时区
        System.out.println(c31.millis()); //每次调用将返回当前瞬时时间(UTC)
        Clock c32 = Clock.system(ZoneId.of("Asia/Shanghai"));//上海时区
        System.out.println(c32.millis());//每次调用将返回当前瞬时时间(UTC)
        Clock c4 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Shanghai"));//固定上海时区时钟
        System.out.println(c4.millis());
        Thread.sleep(1000);
        System.out.println(c4.millis()); //不变 即时钟时钟在那一个点不动
        Clock c5 = Clock.offset(c1, Duration.ofSeconds(2)); //相对于系统默认时钟两秒的时钟
        System.out.println(c1.millis());
        System.out.println(c5.millis());
    }

    public static void testInstant() {
        //瞬时时间 相当于以前的System.currentTimeMillis()
        Instant instant1 = Instant.now();
        System.out.println(instant1.getEpochSecond());//精确到秒 得到相对于1970-01-01 00:00:00 UTC的一个时间
        System.out.println(instant1.toEpochMilli()); //精确到毫秒
        Clock clock1 = Clock.systemUTC(); //获取系统UTC默认时钟
        Instant instant2 = Instant.now(clock1);//得到时钟的瞬时时间
        System.out.println(instant2.toEpochMilli());
        Clock clock2 = Clock.fixed(instant1, ZoneId.systemDefault()); //固定瞬时时间时钟
        Instant instant3 = Instant.now(clock2);//得到时钟的瞬时时间
        System.out.println(instant3.toEpochMilli());//equals instant1
    }

    public static void testLocalDateTime() {
        //使用默认时区时钟瞬时时间创建 Clock.systemDefaultZone() -->即相对于 ZoneId.systemDefault()默认时区
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //自定义时区
        LocalDateTime now2 = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(now2);//会以相应的时区显示日期
        //自定义时钟
        Clock clock = Clock.system(ZoneId.of("Asia/Dhaka"));
        LocalDateTime now3 = LocalDateTime.now(clock);
        System.out.println(now3);//会以相应的时区显示日期
        //不需要写什么相对时间 如java.util.Date 年是相对于1900 月是从0开始
        //2013-12-31 23:59

        LocalDateTime d1 = LocalDateTime.of(2021, 6, 29, 23, 59);
        //年月日 时分秒 纳秒
        LocalDateTime d2 = LocalDateTime.of(2021, 6, 29, 23, 59, 59, 11);
        //使用瞬时时间 + 时区
        Instant instant = Instant.now();
        LocalDateTime d3 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(d3+"---d3");

        //解析String--->LocalDateTime
        LocalDateTime d4 = LocalDateTime.parse("2013-12-31T23:59");
        System.out.println(d4);
        LocalDateTime d5 = LocalDateTime.parse("2013-12-31T23:59:59.999");//999毫秒 等价于999000000纳秒
        System.out.println(d5);

        //使用DateTimeFormatter API 解析 和 格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime d6 = LocalDateTime.parse("2013-12-31 23:59:59", formatter);
        System.out.println(formatter.format(d6)+"---d6");

        //时间获取
        System.out.println(d6.getYear());
        System.out.println(d6.getMonth());
        System.out.println(d6.getDayOfYear());
        System.out.println(d6.getDayOfMonth());
        System.out.println(d6.getDayOfWeek());
        System.out.println(d6.getHour());
        System.out.println(d6.getMinute());
        System.out.println(d6.getSecond());
        System.out.println(d6.getNano());

        //时间增减
        LocalDateTime d7 = d6.minusDays(1);
        LocalDateTime d8 = d7.plus(1, IsoFields.QUARTER_YEARS);
        //LocalDate 即年月日 无时分秒
        //LocalTime即时分秒 无年月日
        //API和LocalDateTime类似就不演示了

        // 两个日期是否相等
        System.out.println(d1.equals(d2));

//        // MonthDay - 用来检查生日
//        LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
//        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
//        MonthDay currentMonthDay = MonthDay.from(today);
//        System.out.println(currentMonthDay.equals(birthday));
//
//        // YearMonth - 用来检查信用卡过期
//        YearMonth currentYearMonth = YearMonth.now(); System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
//        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
//        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
//
//        // 判断闰年 - LocalDate类有一个isLeapYear()的方法
//        System.out.println(dateOfBirth.isLeapYear());
    }

    public static void main(String[] args) throws InterruptedException {
        //testClock();
       // testInstant();
        testLocalDateTime();
    }
}
