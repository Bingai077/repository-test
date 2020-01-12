package cn.bingai.practice01.demo02.chapter06_OOP3.test8;

public class Circle {
    private Double redius;

    public Circle() {
    }

    public Circle(Double redius) {
        this.redius = redius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "redius=" + redius +
                '}';
    }

    public Double getRedius() {
        return redius;
    }

    public void setRedius(Double redius) {
        this.redius = redius;
    }
}
