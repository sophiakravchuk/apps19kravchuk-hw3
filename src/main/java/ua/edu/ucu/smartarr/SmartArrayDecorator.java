package ua.edu.ucu.smartarr;

import java.util.Arrays;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) { this.smartArray = smartArray; }

    @Override
    public abstract Object[] toArray();

    @Override
    public int size() { return this.toArray().length; }

    @Override
    public String operationDescription() {  return getClass().getSimpleName(); }

    @Override
    public String toString() { return Arrays.toString(this.toArray()); }
}
