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
        apply(smartArray);
    }

    @Override
    protected void apply(SmartArray sa) {
        int len = sa.size();
        Object[] array = sa.toArray();
        Arrays.sort(array, comparator);
        super.apply(new BaseArray(array));
    }
}
