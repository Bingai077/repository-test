package cn.bingai.practice01.demo02.chapter06_OOP3.test14;

public class Test1 {
    public static void main(String[] args) {
        Car c1 = new Car(45);
        Car c2 = new Car(-5);
        Car c3 = new Car(15);

        Car.Air c11 = c1.new Air();
        Car.Air c22 = c2.new Air();
        Car.Air c33 = c3.new Air();

        c11.flow();
        c22.flow();
        c33.flow();


    }
}

class Car{
    public Car() {
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }

    private double temperature;

    class Air{
        public void flow(){
            if (temperature >= 40){
                System.out.println("吹冷气");
            }else if(temperature < 0){
                System.out.println("吹暖气");
            }else{
                System.out.println("关闭空调");
            }
        }
    }
}

