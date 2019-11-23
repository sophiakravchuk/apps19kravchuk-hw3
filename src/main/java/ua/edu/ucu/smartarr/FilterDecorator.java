package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    protected MyPredicate filter;

    public FilterDecorator(SmartArray smartArray, MyPredicate filter) {
        super(smartArray);
        this.filter = filter;
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        int len = array.length;
        array = Arrays.copyOf(array, len);
        int newLen = 0;
        Object[] localArray = new Object[len];
        for (int i = 0; i < len; i++) {
            if(!filter.test(array[i])) continue;
            localArray[newLen] = array[i];
            newLen++;
        }
        return Arrays.copyOf(localArray, newLen);
    }
}
