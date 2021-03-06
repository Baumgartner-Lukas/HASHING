package com.baumgartner.HashSet;

import com.baumgartner.Interfaces.MyHashSet;

public class ChainingHashSet implements MyHashSet {
    private ChainingHashNode[] elements;
    private int size;
    private static int SET_SIZE = 10;

    public ChainingHashSet() {
        elements = new ChainingHashSet.ChainingHashNode[SET_SIZE];
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
            elements[pos] = node;
            size++;
            return true;
        } else {
            ChainingHashNode head = elements[pos];
            while(head.next != null) {
                    head = head.next;
            }
            head.next = node;
            size++;
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
//        for (ChainingHashNode n : elements) {
//            while (n != null) {
//                if (key.compareTo(n.key) == 0) {
//                    return true;
//                }
//                n = n.next;
//            }
//        }
        ChainingHashNode node = elements[hashCode(key)];
        while(node != null){
            if(node.key.equals(key))return true;
            node = node.next;
        }
        return false;
    }

    /**
     * Removes the provided key from the set
     *
     * @param key key that should be removed from the set
     * @return returns true if the key was found and removed. False otherwise.
     * @throws IllegalArgumentException if no key is provided, an Exception is thrown.
     */
    @Override
    public boolean remove(Integer key) throws IllegalArgumentException {
        if (key == null) throw new IllegalArgumentException("Key must not be null");
        else if (!contains(key)) {
            System.err.println("Key is not in the set");
            return false;
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null && elements[i].key.equals(key) && elements[i].next == null) {
                    elements[i] = null;
                    size--;
                    return true;
                } else {
                    ChainingHashNode node = elements[i];
                    while (node != null) {
                        if (node.key.equals(key)) {
                            node = node.next;
                            elements[i] = node;
                            size--;
                            return true;
                        } else if (node.next != null && node.next.key.equals(key)) {
                            node.next = node.next.next;
                            size--;
                            return true;
                        }
                        node = node.next;
                    }
                }
            }

        }
        return false;
    }

    @Override
    public void clear() {
        this.elements = new ChainingHashSet.ChainingHashNode[10];
    }

    /**
     * calculates the hashvalue based on the size of the elements array
     *
     * @param key key element of key-value pair. Hashvalue
     * @return returns hashvalue for key
     */
    private int hashCode(int key) {
        return (key % elements.length);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (ChainingHashNode n : elements) {
            while (n != null) {
                stringBuffer.append("Index: ").append(hashCode(n.key)).append(" Key: ").append(n.key).append(" Value: ").append(n.data).append("\n");
                n = n.next;
            }
        }
        return stringBuffer.toString();
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
