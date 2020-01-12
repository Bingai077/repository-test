package cn.bingai.practice01.demo02.chapter06_OOP3.test14;

public class Test4 {
    public static void main(String[] args) {

        Lenovo lenovo = new Lenovo();
        Lenovo.Development ld = lenovo.new Development();
        Lenovo.Sales ls = lenovo.new Sales();
        Lenovo.Sales ls1 = new Lenovo().new Sales();
        ld.work();
        ls.work();
        ls1.work();

    }


}

class Lenovo{

    public interface Works{
        public abstract void work();
    }

    public class Development implements Works{

        @Override
        public void work() {
            System.out.println("软件开发");
        }
    }

    public class Sales implements Works{

        @Override
        public void work() {
            System.out.println("市场调研");
        }
    }

}