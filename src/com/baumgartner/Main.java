package com.baumgartner;

import com.baumgartner.HashSet.ChainingHashSet;
import com.baumgartner.HashSet.LinearHashSet;

public class Main {

    public static void main(String[] args) {
        ChainingHashSet set = new ChainingHashSet();
        LinearHashSet linearHashSet = new LinearHashSet();


        set.insert(1,"1");
        set.insert(11, "11");
        set.insert(21,"21");
        set.insert(31, "31");
        set.insert(41, "41");
        set.insert(51, "51");


        System.out.println(set.toString());

        set.remove(21);
        set.insert(61, "61");
        System.out.println(set.contains(1));

        System.out.println(set.toString());

//        linearHashSet.insert(4, "4");
//        linearHashSet.insert(14, "14");
//        linearHashSet.insert(24, "24");
//        linearHashSet.insert(34, "34");
//        linearHashSet.insert(44, "44");
//        linearHashSet.insert(54, "54");
//
//        System.out.println(linearHashSet.toString());
//
//        linearHashSet.remove(44);
//
//        System.out.println(linearHashSet.toString());



    }
}
