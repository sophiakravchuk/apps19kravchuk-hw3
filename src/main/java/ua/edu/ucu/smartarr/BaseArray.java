package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] myArray = null;
    private String currentOperation = "";

    public BaseArray(Object[] myArray) {
        this.myArray = myArray;
    }

    public void setValue(int index) {
        myArray[index] = 0;
    }

    // return array with SmartArray elements
    @Override
    public Object[] toArray() { return myArray; }

    // return current operation name applied to SmartArray
    public String operationDescription() {
        return currentOperation;
    }
    // return SmartArray size
    @Override
    public int size() { return myArray.length; }

    @Override
    public String toString() { return Arrays.toString(myArray); }
}