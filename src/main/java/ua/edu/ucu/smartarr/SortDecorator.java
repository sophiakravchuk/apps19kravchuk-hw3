package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    protected MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }


    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        int len = array.length;
        array = Arrays.copyOf(array, len);
        Arrays.sort(array, comparator);
        return array;
    }
}
