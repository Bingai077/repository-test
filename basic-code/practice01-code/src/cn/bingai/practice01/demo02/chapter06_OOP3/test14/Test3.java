package cn.bingai.practice01.demo02.chapter06_OOP3.test14;

public class Test3 {
    public static void main(String[] args) {
        Cellphone cell = new Cellphone();
        Cellphone.CellCal cellCal = cell.new CellCal();
        Cellphone.CellClo cellClo = cell.new CellClo();
        cellCal.work();
        cellClo.work();
    }

}

class Cellphone {

     public class CellCal implements Calculator{

        @Override
        public void work() {
            System.out.println("运算");
        }
    }

    public class CellClo implements Clock{

        @Override
        public void work() {
            System.out.println("计时");
        }
    }

}

interface Calculator {
    public abstract void work();
}

interface Clock {
    public abstract void work();
}