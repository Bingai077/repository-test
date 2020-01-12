package cn.bingai.practice01.demo02.chapter06_OOP3.test8;

public class ComparableRectangle extends  Rectangle implements CompareObject{
    public ComparableRectangle() {
    }

    public ComparableRectangle(Double length, Double width) {
        super(length, width);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if(o instanceof ComparableRectangle){
            ComparableRectangle c = (ComparableRectangle) o;
            return this.getArea().compareTo(c.getArea());
        }else{
            throw new RuntimeException("对象类型不对");
        }
    }
}
