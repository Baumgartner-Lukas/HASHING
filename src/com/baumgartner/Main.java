package com.baumgartner;

import com.baumgartner.HashSet.ChainingHashSet;

public class Main {

    public static void main(String[] args) {
        ChainingHashSet set = new ChainingHashSet();

        set.insert(1,"1");
        set.insert(11, "11");
        set.insert(21,"21");
        set.insert(31, "31");
        set.insert(41, "41");
        set.insert(51, "51");


        System.out.println(set.toString());

        set.remove(21);
        set.insert(61, "61");

        System.out.println(set.toString());



    }
}
