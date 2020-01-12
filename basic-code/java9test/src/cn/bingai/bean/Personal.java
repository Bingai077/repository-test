package cn.bingai.bean;

/**
 * @author bingai
 * @create 2019-11-16 10:50
 */
public class Personal {
    private String name;
    private int age;

    public Personal() {
    }

    public Personal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
