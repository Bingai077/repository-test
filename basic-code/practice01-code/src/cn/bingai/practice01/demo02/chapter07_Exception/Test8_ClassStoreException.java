package cn.bingai.practice01.demo02.chapter07_Exception;
//ClassStoreException 数组元素不匹配
public class Test8_ClassStoreException {
    public static void main(String[] args) {
        Object obj[] = new String[5];
        try{
            for (int i = 0; i < obj.length; i++) {
                obj[i] = new Integer(i);
                System.out.println(obj[i]);
            }
        }catch (ArrayStoreException e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("ending");
    }
}
