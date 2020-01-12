package cn.bingai.practice01.demo02.chapter04_OOP1.test1pro;

public class Student {
    private int number;
    private int state;
    private int score;

    public Student() {
    }

    public Student(int number, int state, int score) {
        this.number = number;
        this.state = state;
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", state=" + state +
                ", score=" + score +
                '}';
    }
}
