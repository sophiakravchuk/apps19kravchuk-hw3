package ua.edu.ucu.smartarr;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        int newLen = 0;
        Object[] array = smartArray.toArray();
        int len = array.length;
        array = Arrays.copyOf(array, len);
        Object[] localArray = new Object[len];
        for (int i = 0; i < len; i++) {
            if(array[i] == null) continue;
            localArray[newLen] = array[i];
            newLen++;
            for (int j = i + 1; j < len; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = null;
                }
            }
        }
        return Arrays.copyOf(localArray, newLen);
    }
    @Override
    public String toString() { return super.toString(); }
}
