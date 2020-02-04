package org.mindrot.jbcrypt;

/**
 * @author bingai
 * @create 2020-01-15 18:50
 */
public class Test2 {
    public static void main(String[] args) {
        boolean checkpw = BCrypt.checkpw("123456", "$2a$10$FijwQmwmT.XshwYYAyWhqu1YwwnX6ImIrxPF3fxmvXoDm8g.BWumK");
        System.out.println(checkpw);
    }
}
