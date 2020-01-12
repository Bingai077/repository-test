package cn.bingai.practice01.demo02.chapter06_OOP3.test18pro;

public class FruitGardener {
    public Fruit getFruit(String fruitName) throws Exception {
        if(fruitName.equalsIgnoreCase("apple")){
            return new Apple();
        }else if (fruitName.equalsIgnoreCase("stuawberry")){
            return new Stuawberry();
        }else if (fruitName.equalsIgnoreCase("grape")){
            return new Grape();
        }else{
            throw new Exception("此庄园无此水果");
        }
    }

}
