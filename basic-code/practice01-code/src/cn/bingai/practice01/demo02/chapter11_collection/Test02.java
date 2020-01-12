package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 请把学生名与考试分数录入到集合中，
 * 并按分数显示前三名成绩学员的名字。
 * @author bingai
 * @create 2019-11-06 15:39
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Student> treeSet = new TreeSet<>();
        System.out.println("请输入学生的姓名和成绩(输入负数时结束)：");

        int count = 0;
        while(true){
            count++;
            System.out.println("请输入第" + count +"个学生的姓名：");
            String name = sc.next();
            System.out.println("请输入第" + count +"个学生的成绩：");
            int score = sc.nextInt();

            if(score < 0){
                break;
            }else{
                treeSet.add(new Student(name,score));
            }
        }
        sc.close();

        System.out.println("学生成绩单为：");
        for (Student student : treeSet) {
            System.out.println(student.getName() + "===" + student.getScore());
        }

        System.out.println("前三名学生成绩单为：");
        int num = 0;
        for (Student student : treeSet) {
            if(num == 3){
                break;
            }else{
                System.out.println(student.getName() + "===" + student.getScore());
                num++;
            }

        }
    }


}


class Student implements Comparable<Student>{
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (score != student.score) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + score;
        return result;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score == o.score){
            return this.name.compareTo(o.name);
        }else{
            return o.score - this.score;
        }

    }
}
