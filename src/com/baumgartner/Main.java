package com.baumgartner;

import com.baumgartner.HashSet.ChainingHashSet;

public class Main {

    public static void main(String[] args) {
        ChainingHashSet set = new ChainingHashSet();

        set.insert(1,"1");
        set.insert(4,"4");
        set.insert(15, "15");
        set.insert(11, "11");

        System.out.println(set.toString());

    }
}
