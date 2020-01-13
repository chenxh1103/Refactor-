package org.chenxh.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
    //@Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
    public void task(){
        System.out.println("这是task测试");
    }

/*    一个cronExpression表达式有至少6个（也可能是7个）由空格分隔的时间元素。从左至右，这些元素的定义如下：
秒0-59 , - * /
分0-59 , - * /
小时0-23 , - * /
日1-31 , - * ? / L W C
月1-12 or JAN-DEC , - * /
周几1-7 or SUN-SAT , - * ? / L C #
年(可选字段) empty, 1970-2099 , - * /

可用值详细分析如下：
“*”——字符可以用于所有字段，在“分”字段中设为"*"表示"每一分钟"的含义。
“?”——字符可以用在“日”和“周几”字段.它用来指定'不明确的值'.这在你需要指定这两个字段中的某一个值而不是另外一个的时候会被用到。在后面的例子中可以看到其含义。
“-”——字符被用来指定一个值的范围，比如在“小时”字段中设为"10-12"表示"10点到12点"。
“,”——字符指定数个值。比如在“周几”字段中设为"MON,WED,FRI"表示"the days Monday, Wednesday, and Friday"。
“/”——字符用来指定一个值的的增加幅度.比如在“秒”字段中设置为"0/15"表示"第0, 15, 30,和45秒"。而"5/15"则表示"第5, 20, 35,和50".在'/'前加"*"字符相当于指定从0秒开始.每个字段都有一系列可以开始或结束的数值。对于“秒”和“分”字段来说，其数值范围为0到59，对于“小时”字段来说其为0到23,对于“日”字段来说为0到31,而对于“月”字段来说为1到12。"/"字段仅仅只是帮助你在允许的数值范围内从开始"第n"的值。
“L”——字符可用在“日”和“周几”这两个字段。它是"last"的缩写,但是在这两个字段中有不同的含义。例如,“日”字段中的"L"表示"一个月中的最后一天" ——对于一月就是31号对于二月来说就是28号（非闰年）。而在“周几”字段中,它简单的表示"7" or "SAT"，但是如果在“周几”字段中使用时跟在某个数字之后,它表示"该月最后一个星期×" ——比如"6L"表示"该月最后一个周五"。当使用'L'选项时,指定确定的列表或者范围非常重要，否则你会被结果搞糊涂的。
“W”——可用于“日”字段。用来指定历给定日期最近的工作日(周一到周五)。比如你将“日”字段设为"15W"，意为: "离该月15号最近的工作日"。因此如果15号为周六，触发器会在14号即周五调用。如果15号为周日,触发器会在16号也就是周一触发。如果15号为周二,那么当天就会触发。然而如果你将“日”字段设为"1W",而一号又是周六,触发器会于下周一也就是当月的3号触发,因为它不会越过当月的值的范围边界。'W'字符只能用于“日”字段的值为单独的一天而不是一系列值的时候。
“L”和“W”可以组合用于“日”字段表示为'LW'，意为"该月最后一个工作日"。
“#”——字符可用于“周几”字段。该字符表示“该月第几个周×”，比如"6#3"表示该月第三个周五( 6表示周五而"#3"该月第三个)。再比如: "2#1" =表示该月第一个周一而"4#5" =该月第五个周三。注意如果你指定"#5"该月没有第五个“周×”，该月是不会触发的。
“C”——字符可用于“日”和“周几”字段，它是"calendar"的缩写。它表示为基于相关的日历所计算出的值（如果有的话）。如果没有关联的日历,那它等同于包含全部日历。“日”字段值为"5C"表示"日历中的第一天或者5号以后"，“周几”字段值为"1C"则表示"日历中的第一天或者周日以后"。

一些例子：
"0 0 12 * * ?"每天中午十二点触发
"0 15 10 ? * *"每天早上10：15触发
"0 15 10 * * ?"每天早上10：15触发
"0 15 10 * * ? *"每天早上10：15触发
"0 15 10 * * ? 2005" 2005年的每天早上10：15触发
"0 * 14 * * ?"每天从下午2点开始到2点59分每分钟一次触发
"0 0/5 14 * * ?"每天从下午2点开始到2：55分结束每5分钟一次触发
"0 0/5 14,18 * * ?"每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
"0 0-5 14 * * ?"每天14:00至14:05每分钟一次触发
"0 10,44 14 ? 3 WED"三月的每周三的14：10和14：44触发
"0 15 10 ? * MON-FRI"每个周一、周二、周三、周四、周五的10：15触发
"0 15 10 15 * ?"每月15号的10：15触发
"0 15 10 L * ?"每月的最后一天的10：15触发
"0 15 10 ? * 6L"每月最后一个周五的10：15
*/

}
