package cn.bingai.practice01.demo02.chapter16_Java8NEW.Optional;

/**
 * @author bingai
 * @create 2019-11-15 17:28
 */
public class Girl {
    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
