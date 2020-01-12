package cn.bingai.practice01.demo02.chapter16_Java8NEW.Optional;

/**
 * @author bingai
 * @create 2019-11-15 17:28
 */
public class Boy {

    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
