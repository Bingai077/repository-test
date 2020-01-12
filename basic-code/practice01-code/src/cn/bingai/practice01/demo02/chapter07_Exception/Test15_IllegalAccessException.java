package cn.bingai.practice01.demo02.chapter07_Exception;

import java.lang.reflect.Field;

//IllegalAccessException 非法访问
public class Test15_IllegalAccessException {
    public static void main(String[] args) {
        Class<?> clazz = String.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.getName().equals("hash")){
                try {
                    System.out.println(field.getInt("hash"));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
