package com.capgeminitraining.day5.junit;

import java.util.List;

public class ListManager {
    // Adds an element to the list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Removes an element from the list
    public boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element)); // Removes by value, not index
    }

    // Returns the size of the list
    public int getSize(List<Integer> list) {
        return list.size();
    }
}
