package cn.bingai.practice01.demo02.chapter06_OOP3.test5_templateMethod;

/*
模板方法的设计模式

 */
public class TemplateTest {
    public static void main(String[] args) {
        Template sub = new SubTemplate();

        sub.spendtime();

    }

}

abstract class Template {

    //计算某段代码执行所需要花费的时间
    public void spendtime()

    {
        long start = System.currentTimeMillis();

        this.code();//不确定，异变的部分

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));
    }

    public abstract void code();
}

class SubTemplate extends Template {

    @Override
    public void code() {

        for (int i = 2; i <= 1000; i++) {
            boolean isFlag = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }

            }
            if (isFlag){
                System.out.println(i);
            }
        }
    }
}
