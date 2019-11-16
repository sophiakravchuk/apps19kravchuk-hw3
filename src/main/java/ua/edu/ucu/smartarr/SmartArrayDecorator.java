package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) { }

    protected void apply(SmartArray sa) { smartArray = sa; }

    @Override
    public Object[] toArray() { return this.smartArray.toArray(); }

    @Override
    public int size() { return this.smartArray.size(); }

    @Override
    public String toString() { return this.smartArray.toString(); }

    @Override
    public String operationDescription() {  return getClass().getSimpleName(); }
}
