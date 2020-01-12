package cn.bingai.practice01.demo01;
/*
题目：求0—7所能组成的奇数个数。

程序分析：最少也是1位数，最多能组成8位的数字
第一位不能为零，最后一位不能是偶数
0到7有四个奇数
这里用累加求和

 */
public class Test43 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        arr[0] = 4;//一位数
        arr[1] = 7 * arr[0];//两位数
        int sum = 0;
        for (int i = 2; i < 8; i++) {
            arr[i] = arr[i-1] * 8;
        }
        for (int i = 0; i < 8; i++) {
            sum = sum + arr[i];
        }
        System.out.println(sum);


//        int n = 8;//位数
//        int sum = 0;//总和
//        // 1位数情况
//        sum += n / 2;
//        // 2位数情况
//        sum += (n - 1) * n / 2;
//        // 3位数情况
//        sum += (n - 1) * n * n / 2;
//        // 4位数情况
//        sum += (n - 1) * n * n * n / 2;
//        // 5位数情况
//        sum += (n - 1) * n * n * n * n / 2;
//        // 6位数情况
//        sum += (n - 1) * n * n * n * n * n / 2;
//        // 7位数情况
//        sum += (n - 1) * n * n * n * n * n * n / 2;
//        // 8位数情况
//        sum += (n - 1) * n * n * n * n * n * n * n / 2;
//        System.out.println("0到7能组成的奇数个数：" + sum);
    }
}
