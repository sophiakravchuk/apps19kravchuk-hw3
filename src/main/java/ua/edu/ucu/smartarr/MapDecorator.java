package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    protected MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
        apply(smartArray);
    }

    @Override
    protected void apply(SmartArray sa) {
        int len = sa.size();
        Object[] array = sa.toArray();
        Object[] localArray = new Object[len];
        for (int i = 0; i < len; i++) {
            localArray[i] = function.apply(array[i]);
        }
        super.apply(new BaseArray(localArray));
    }
}