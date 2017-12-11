package com.baumgartner.HashSet;

import com.baumgartner.Interfaces.MyHashSet;

public class LinearHashSet implements MyHashSet {
    private OpenHashNode[] elements;
    private int size;
    private static int SET_SIZE = 5;

    public LinearHashSet() {
        elements = new OpenHashNode[SET_SIZE];
        size = 0;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean insert(Integer key, String data) throws IllegalArgumentException {
        if (key == null || data.isEmpty()) throw new IllegalArgumentException("Key or data must not be empty");
        if (contains(key)) return false;
        if (size == SET_SIZE) {
            System.out.println("Set is full. Key " + key + " was not inserted");
            return false; // no more space in set;
        }
        OpenHashNode node = new OpenHashNode(key, data);
        int pos = hashCode(key);
        if (elements[pos] == null) {
            elements[pos] = node;
            size++;
            return true;
        } else {
            while (elements[pos] != null) {
                if (!elements[pos].removed) {
                    if (pos == elements.length - 1) {
                        pos = 0;
                    } else {
                        pos = pos + 1;
                    }
                }
            }
            elements[pos] = node;
            size++;
            return true;
        }
    }

    /**
     * Checks if key is already in the set.
     *
     * @param key
     * @return returns true if the key is in the set. False otherwise.
     * @throws IllegalArgumentException
     */
    @Override
    public boolean contains(Integer key) throws IllegalArgumentException {
        if (key == null) throw new IllegalArgumentException("Key must not be null");
        for (OpenHashNode n : elements) {
            if (n != null && key.compareTo(n.key) == 0 && !n.removed) {
                return true;
            }
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
        if (!contains(key)) {
            System.out.println("Key not in list");
            return false;
        }
        for (OpenHashNode n : elements) {
            if (key.equals(n.key)) {
                n.removed = true;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.elements = new OpenHashNode[10];
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
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < SET_SIZE; i++) {
            if (elements[i] != null) {
                if (!elements[i].removed) {
                    stringBuffer.append("Index: ").append(i).append(" Key: ").append(elements[i].key).append(" Value: ").append(elements[i].data).append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    private class OpenHashNode {
        private Integer key;
        private String data;
        boolean removed = false;

        private OpenHashNode(Integer key, String data) {
            this.key = key;
            this.data = data;
            removed = false;
        }


    }
}

