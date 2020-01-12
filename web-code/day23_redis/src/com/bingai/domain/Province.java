package com.bingai.domain;

/**
 * @author bingai
 * @create 2019-12-05 16:20
 */
public class Province {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
