package com.baumgartner.HashSet;

import com.baumgartner.Interfaces.MyHashSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChainingHashSet implements MyHashSet {
    private ChainingHashNode[] elements;
    private int size;

    public ChainingHashSet() {
        elements = (ChainingHashNode[]) new ChainingHashSet.ChainingHashNode[10];
        size = 0;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean insert(Integer key, String data) throws IllegalArgumentException {
        return false;
    }

    @Override
    public boolean contains(Integer key) throws IllegalArgumentException {
        return false;
    }

    @Override
    public boolean remove(Integer key) throws IllegalArgumentException {
        return false;
    }

    @Override
    public void clear() {
    }

    private class ChainingHashNode {
        private Integer key;
        private String data;
        ChainingHashNode next;

        private ChainingHashNode(Integer key, String data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }

    }
}
