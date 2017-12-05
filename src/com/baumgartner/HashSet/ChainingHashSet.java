package com.baumgartner.HashSet;

import com.baumgartner.Interfaces.MyHashSet;

import java.util.Arrays;

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
        if (key == null || data.isEmpty()) throw new IllegalArgumentException("Key or data must not be empty");
        ChainingHashNode node = new ChainingHashNode(key, data);
        int pos = hashCode(key);
        if (contains(key)) return false;
        if (elements[pos] == null) {
            elements[hashCode(key)] = node;
        } else {
            elements[pos].next = node;
        }
        return true;
    }

    /**
     * Checks if key is already in the set.
     *
     * @param key
     * @return returns true if the key is not in the set. False otherwise.
     * @throws IllegalArgumentException
     */
    @Override
    public boolean contains(Integer key) throws IllegalArgumentException {
        if (key == null) throw new IllegalArgumentException("Key must not be null");
        for (ChainingHashNode n : elements) {
            while (n != null) {
                if (key.compareTo(n.key) == 0) {
                    System.err.println("Key already in set");
                    return true;
                }
                n = n.next;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Integer key) throws IllegalArgumentException {
        return false;
    }

    @Override
    public void clear() {
    }

    /**
     * calculates the hashvalue based on the size of the elements array
     *
     * @param key key element of key-value pair. Hashvalue
     * @return returns hashvalue for key
     */
    public int hashCode(int key) {
        return (key % elements.length);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (ChainingHashNode n : elements) {
            while (n != null) {
                buffer.append("Key: ").append(n.key).append("Value: ").append(n.data);
                n = n.next;
            }
        }
        return buffer.toString();
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
