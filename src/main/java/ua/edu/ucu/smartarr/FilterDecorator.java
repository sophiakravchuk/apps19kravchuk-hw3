package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    protected MyPredicate filter;

    public FilterDecorator(SmartArray smartArray, MyPredicate filter) {
        super(smartArray);
        this.filter = filter;
        apply(smartArray);
    }

    @Override
    protected void apply(SmartArray sa) {
        int len = sa.size();
        int newLen = 0;
        Object[] array = sa.toArray();
        Object[] localArray = new Object[len];
        for (int i = 0; i < len; i++) {
            if(!filter.test(array[i])) continue;
            localArray[newLen] = array[i];
            newLen++;
        }
        Object[] newArr = Arrays.copyOf(localArray, newLen);
        super.apply(new BaseArray(newArr));
    }
}
