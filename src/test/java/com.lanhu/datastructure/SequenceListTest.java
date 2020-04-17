package com.lanhu.datastructure;

import com.lanhu.datastructure.list.List;
import com.lanhu.datastructure.list.SequenceList;

/**
 * @author 蓝狐
 */
public class SequenceListTest {
    public static void main(String[] args){
        List<String> list = new SequenceList<String>();
        list.add("test1");
        list.add("test2");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.remove();
        System.out.println(list.size());
        //list.add("test3");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.add("test3");
        list.add("test4");
        list.add("test2",1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
