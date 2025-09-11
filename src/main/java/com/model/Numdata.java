package com.model;

public class Numdata {
    private int id;
    private static int num;

    public Numdata(int myid, int mynum) {
        id = myid;
        num = mynum;
    }

    public static int getNum() {
        return num;
    }

    public void setNum(int num) {
        Numdata.num = num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
