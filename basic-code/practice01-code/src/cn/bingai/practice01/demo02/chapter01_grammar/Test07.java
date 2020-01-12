package cn.bingai.practice01.demo02.chapter01_grammar;
/*
实现基本数据类型的类型转换

低级别     高级别
byte      short、int、long、float、double
short     int、long、float、double
int       long、float、double
long      float、double
char      int、long、float、double
float     double

 */
public class Test07 {
    public static void main(String[] args) {
        byte b = 50;
        short s = 60;
        int i = 100;
        long l = 1000L;
        float f = 0.5F;
        double d = 3.14159;
        char c ='a';
        boolean bo = true;

        //低转高
        System.out.println("========低转高========");
        System.out.println("累加byte等于：" + b);
        System.out.println("累加char等于：" + (b + c));
        System.out.println("累加short等于：" + (b + c + s));
        System.out.println("累加int等于：" + (b + c + s +i));
        System.out.println("累加long等于：" + (b + c + s +i + l));
        System.out.println("累加float等于：" + (b + c + s +i + l + f));
        System.out.println("累加double等于：" + (b + c + s +i + l + f + d));

        //高转低
        System.out.println("========高转低(强制)========");
        System.out.println("long转int：" + ((int)l + 100));
        System.out.println("long转byte(数据丢失)：" + ((byte)l));//数据丢失
        System.out.println("double转int(舍弃小数)：" + ((int)d));//舍弃小数
        System.out.println("int转char(获取字符)：" + ((char)i));//获取字符


    }
}
