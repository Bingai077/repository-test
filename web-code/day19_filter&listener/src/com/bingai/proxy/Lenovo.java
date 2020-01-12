package com.bingai.proxy;

/**真实类
 * @author bingai
 * @create 2019-12-03 17:50
 */
public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {

        System.out.println("花了" + money +"元买了一台联想电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑。。。");
    }
}
