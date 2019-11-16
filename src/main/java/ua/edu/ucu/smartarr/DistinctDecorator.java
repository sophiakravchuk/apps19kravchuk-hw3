package ua.edu.ucu.smartarr;

        import java.util.ArrayList;
        import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        apply(smartArray);
    }

    @Override
    protected void apply(SmartArray sa) {
        int len = sa.size();
        int newLen = 0;
        Object[] array = Arrays.copyOf(sa.toArray(), sa.size());
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
        Object[] newArr = Arrays.copyOf(localArray, newLen);
        super.apply(new BaseArray(newArr));
    }
//
//    @Override
//    public String operationDescription() { return "DistinctDecorator"; }
}
