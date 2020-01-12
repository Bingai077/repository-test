package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：输入三个整数x,y,z，请把这三个数由小到大输出。

程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，
如果x>y则将x与y的值进行交换，然后再用x与z进行比较，
如果x>z则将x与z的值进行交换，这样能使x最小。

最后两个数也使z>y就可以了

 */
public class Test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int x = sc.nextInt();
        System.out.println("请输入第二个整数：");
        int y = sc.nextInt();
        System.out.println("请输入第三个整数：");
        int z = sc.nextInt();

        method1(x, y, z);

        method2(x, y, z);

        sc.close();


    }

    public static void method1(int a, int b, int c) {

//       int temp1 = a > b ? a : b;//只是取出大的数并没有排序
//       int temp2 = a > c ? a : c;
//       int temp3 = b > c ? b : c;
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (a > c) {
            temp = a;
            a = c;
            c = temp;
        }
        if (b > c) {
            temp = b;
            b = c;
            c = temp;
        }
        System.out.println(a + " " + b + " " + c);

    }


    public static void method2(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);//调用Arrays中的排序方法
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}

