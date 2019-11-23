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
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        int len = array.length;
        array = Arrays.copyOf(array, len);
        for (int i = 0; i < len; i++) {
            array[i] = function.apply(array[i]);
        }
        return array;
    }
}