package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

public class Test {
    private static void printTest(SmartArray sa){
        System.out.println(sa.toString());
        System.out.println(sa.operationDescription());
    }

    public static void main(String[] args) {
        BaseArray a = new BaseArray(new Integer[]{1,2,3,4,5});
        MapDecorator b = new MapDecorator(a,x->(Integer)x*(Integer)x);
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));
        a.setValue(0); // що це працювало додайте метод setValue(int index){array[index] = 0};
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));


        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        Integer[] ints = {-1, 2, 0, 1, -5, 3, -1, 2, 0, 1, -5, 3};
        SmartArray sa = new BaseArray(ints);
        System.out.println(sa.toString());

        printTest(sa = new DistinctDecorator(sa)); // Result: [2, 1, 3];
        printTest(sa = new FilterDecorator(sa, pr)); // Result: [2, 1, 3];
        printTest(sa = new MapDecorator(sa, func)); // Result: [2, 4, 6]
        printTest(sa = new SortDecorator(sa, cmp)); // Result: [1, 2, 3]
    }
}
