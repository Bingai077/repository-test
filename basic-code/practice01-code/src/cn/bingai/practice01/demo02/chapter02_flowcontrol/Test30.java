package cn.bingai.practice01.demo02.chapter02_flowcontrol;

/*
    Ean-13码规则：第十三位数字是前十二位数字经过计算得到的校验码。
        例如：690123456789
        计算其校验码的过程为：
        ① 前十二位的奇数位和6+0+2+4+6+8=26
        ② 前十二位的偶数位和9+1+3+5+7+9=34
        ③ 将奇数和与偶数和的三倍相加26+34*3=128
        ④ 取结果的个位数：128的个位数为8
        ⑤ 用10减去这个个位数10-8=2
        所以校验码为2
        （注：如果取结果的个位数为0，那么校验码不是为10（10-0=10），而是0）
        实现上述代码的功能，计算验证码，输入12位条码，返回带验证码的条码。
        例：输入：692223361219输出：6922233612192

 */
public class Test30 {
    public static void main(String[] args) {
        String str = "692223361219";
        int sumJ = 0;
        int sumO = 0;
        for (int i = 0; i < 12; i++) {
            if (i % 2 == 0) {
                sumJ += (str.charAt(i) - '0');
            } else {
                sumO += (str.charAt(i) - '0');
            }
        }
        int i = 10 - (sumJ + sumO * 3) % 10;
        System.out.println(str + i);


    }
}
