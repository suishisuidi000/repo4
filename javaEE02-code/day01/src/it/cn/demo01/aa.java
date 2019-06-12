package it.cn.demo01;

import java.util.ArrayList;
import java.util.List;

public class aa {
    public static void main(String[] args) {
        List li = new ArrayList();
        li.add("abc");
        li.add(1);
        System.out.println(li);
        Object[] objects = li.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
