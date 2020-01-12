package cn.bingai.practice01.demo02.chapter07_Exception;

public class Test3_throw {
    public static void main(String[] args) {

        try {
            Student s = new Student();
            s.regist(-1001);
            System.out.println(s);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}

class Student {
    private int id;

    public void regist(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            //System.out.println("您输入的数据非法");
            //手动抛出异常对象
            //throw new RuntimeException("您输入的数据非法");
            //throw new Exception("您输入的数据非法");
            throw new Test4_MyException("不能输出负数");


        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
