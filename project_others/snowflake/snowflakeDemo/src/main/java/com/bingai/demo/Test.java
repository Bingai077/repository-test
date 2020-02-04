package com.bingai.demo;

/**
 * @author bingai
 * @create 2020-01-13 22:03
 */
public class Test {

    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker(1,1);
        for (int i = 0; i < 10000; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }


    }

}
