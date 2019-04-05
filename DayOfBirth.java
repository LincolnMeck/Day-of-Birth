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
            throw new IllegalYearException("年份输入错误！");
        }

        //如果月份大于12或小于1，输出错误提示
        if (month1>12 || month1<1){
            throw new IllegalMonthException("月份输入错误！");
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(name+"，生于"+year1+"年"+month1+"月"+day1+"日，星期"+ (dayweek-1 == 0 ? "日" : dayweek-1) );
        System.out.println("今天是"+year2+"年"+month2+"月"+day2+"日，星期"+ (dayweek2-1 == 0 ? "日" : dayweek2-1) );
    }

}

//出生年份大于今年年份时报错
class IllegalYearException extends RuntimeException{ //非法年份错误
    public IllegalYearException(){
    }
    public IllegalYearException(String msg){
        super(msg);
    }
}

//月份输入错误时报错
class IllegalMonthException extends RuntimeException{ //非法月份错误
    public IllegalMonthException(){
    }
    public IllegalMonthException(String msg){
        super(msg);
    }
}