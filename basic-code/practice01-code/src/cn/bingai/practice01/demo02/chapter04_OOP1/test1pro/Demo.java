package cn.bingai.practice01.demo02.chapter04_OOP1.test1pro;

/*
定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩
score(int)。 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
问题一：打印出3年级(state值为3）的学生信息。
问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息

for (int i = 0; i < stus.length; i++) {
            for (int j = 0; j < stus.length - i - 1; j++) {
                if (stus[j].getScore() > stus[j + 1].getScore()) {

                    //【如果交换顺序，交换的是数组的元素：Student对象】
                    Student temp = stus[j];
                    stus[j] = stus[j+1];
                    stus[j + 1] = temp;
                }
            }
        }

 */
public class Demo {
    public static void main(String[] args) {
        Student[] stus = new Student[20];
        for (int i = 0; i < stus.length; i++) {
            stus[i] = new Student();
            stus[i].setNumber(i + 1);
            stus[i].setState((int) (Math.random() * 6 + 1));
            stus[i].setScore((int) (Math.random() * 101));
        }

        //创建类的对象
        Demo test = new Demo();

        test.print(stus);

        System.out.println("=========================");
        test.searchState(stus,3);

        System.out.println("========================");
        test.sortScore(stus);


    }

    /**
     * @Description 查找Student数组中指定年级的学生信息
     * @author bingai
     * @date  2019.10.24
     * @param stus 要查找的数组
     * @param state 要查找的年级
     */

    public void searchState(Student[] stus,int state){
        for (int i = 0; i < stus.length; i++) {
            if (stus[i].getState() == state) {
                System.out.println(stus[i]);
            }
        }
    }



    public void sortScore(Student[] stus){
        for (int i = 0; i < stus.length; i++) {
            for (int j = 0; j < stus.length - i - 1; j++) {
                if (stus[j].getScore() > stus[j + 1].getScore()) {

                    //如果交换顺序，交换的是数组的元素：Student对象
                    Student temp = stus[j];
                    stus[j] = stus[j+1];
                    stus[j + 1] = temp;
                }
            }
        }
    }



    public void print(Student[] stus){
        for (Student student : stus) {
            System.out.println(student);
        }
    }





}
