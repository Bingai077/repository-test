package org.mindrot.jbcrypt;

/**
 * @author bingai
 * @create 2020-01-15 18:44
 */
public class Test1 {

    public static void main(String[] args){

        String gensalt = BCrypt.gensalt();//创建随机盐
        System.out.println(gensalt);

        String password = BCrypt.hashpw("123456", gensalt);
        System.out.println(password);

    }
}
