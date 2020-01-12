package cn.bingai.practice01.demo02.chapter06_OOP3.test8;

public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle(Double redius) {
        super(redius);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }

        if(o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle)o;
            //错误的
            //return (int)(this.getRedius() -c.getRedius());

            //方式一
            /*if(this.getRedius() > c.getRedius()){
                return 1;
            }else if(this.getRedius() < c.getRedius()){
                return -1;
            }else{
                return 0;
            }*/
            //当属性声明为Double时，可以声明为包装类的方法
            //方式二
            return this.getRedius().compareTo(c.getRedius());

        }else{
//            return 0;
            throw new RuntimeException("传入的数据类型不匹配");
        }
    }
}
