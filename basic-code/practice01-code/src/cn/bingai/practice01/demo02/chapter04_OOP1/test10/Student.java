package cn.bingai.practice01.demo02.chapter04_OOP1.test10;
/*
  编写一个Student类，包含name、gender、age、id、score属性，分别为String、String、int、int、double类型。
类中声明一个say方法，返回String类型，方法返回信息中包含所有属性值。
 */
public class Student {
    private String name;
    private String gender;
    private int age;
    private int id;
    private double score;




    public Student() {
    }

    public Student(String name, String gender, int age, int id, double score) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
        this.score = score;
    }


    public String say() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
