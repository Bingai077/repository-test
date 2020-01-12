package cn.bingai.practice01.demo02.chapter07_Exception;

// NumberFormatException 数字格式转换异常
public class Test11_NumberFormatException {
    public static void main(String[] args) {
        Test11_NumberFormatException t = new Test11_NumberFormatException();
        String name = t.getName();
        int password = 0;
        try{
            password = new Integer(t.getPassword()).intValue();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        System.out.println(name);
        System.out.println(password);


    }


    private String name;
    private  String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
