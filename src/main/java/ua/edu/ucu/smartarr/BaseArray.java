package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] myArray = null;
    private String currentOperation = "";

    public BaseArray(Object[] myArray) {
        this.myArray = myArray;
    }
    public BaseArray() { }

    // return array with SmartArray elements
    @Override
    public Object[] toArray() {
        return myArray;
    }
    // return current operation name applied to SmartArray
    public String operationDescription() {
        return currentOperation;
    }
    // return SmartArray size
    @Override
    public int size() {
        return myArray.length;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        int len = size();
        for (int i = 0; i < len; i++) {
            if (i > 0) { s.append(", "); }
            s.append(myArray[i]);
        }
        s.append("]");
        return s.toString();
    }
}