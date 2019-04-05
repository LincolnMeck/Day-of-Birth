import java.util.Calendar;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class DayOfBirth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String name = scanner.nextLine();

        //出生日期
        /*出生年份*/ System.out.println("请输入出生年份：");
                     int year1 = scanner.nextInt();
        /*出生月份*/ System.out.println("请输入出生月份：");
                     int month1 = scanner.nextInt();
        /*出生号数*/ System.out.println("请输入出生号数：");
                     int day1 = scanner.nextInt();
        /*当天星期*/ Calendar a = new GregorianCalendar(year1,month1-1,day1);
                                   //月份输出为0-11，代表1-12月，因此输入的月份应当减1
                     int dayweek = a.get(Calendar.DAY_OF_WEEK);

        //今天的日期
        Calendar b = new GregorianCalendar();
        int year2 = b.get(Calendar.YEAR);
        int month2 = b.get(Calendar.MONTH)+1;
        int day2 = b.get(Calendar.DAY_OF_MONTH);
        int dayweek2 = b.get(Calendar.DAY_OF_WEEK);//输出为1-7，分别为：日一二三四五六

        //如果出生年大于今年，输出错误提示
        if (year1>year2){
            throw new IllegalException("年份输入错误！");
        }

        //年龄
        int age = year2 - year1;

        //如果月份大于12或小于1，输出错误提示
        if (month1>12 || month1<1){
            throw new IllegalException("月份输入错误！");
        }

        //不同月份的日期不同
        //如果为1、3、5、7、8、10、12月，则大于31号或小于1号提示错误
        if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12){
            if (day1>31 || day1<1){
                throw new IllegalException("号数输入错误！");
            }
        } else if(month1==4 || month1==6 || month1==9 || month1==11){ //如果为4、6、9、11月，则大于30号或小于1号提示异常
            if (day1>30 || day1<1){
                throw new IllegalException("号数输入错误！");
            }
        }else if (month1==2){   //如果为2月，则先判断是不是闰年，如果是，则大于29号或小于1号提示异常；如果不是，则大于28号或小于1号提示异常
            if (year1%4==0 && year1%100!=0 || year1%400==0){ //闰年条件：年数可以被4整除而不能被100整除，但可被400整除
                if (day1>29 || day1<1){
                    throw new IllegalException("号数输入错误！");
                }
            }else{
                if (day1>28 || day1<1){
                    throw new IllegalException("号数输入错误！");
                }
            }
        }

        //汇总输出
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(name+"，"+age+"岁");
        System.out.println("生于"+year1+"年"+month1+"月"+day1+"日，星期"+ (dayweek-1 == 0 ? "日" : dayweek-1) );
        System.out.println("今天是"+year2+"年"+month2+"月"+day2+"日，星期"+ (dayweek2-1 == 0 ? "日" : dayweek2-1) );
    }

}

//报错方法
class IllegalException extends RuntimeException{ //非法错误
    public IllegalException(){
    }
    public IllegalException(String msg){
        super(msg);
    }
}

