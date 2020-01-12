package cn.bingai.practice01.demo02.chapter04_OOP1.test11;

public class Customer {
    private String name;
    private String idCard;
    private String phone;
    private String adress;

    public Customer() {
    }

    public Customer(String name, String idCard, String phone, String adress) {
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.adress = adress;
    }



    public String say() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone=" + phone + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
