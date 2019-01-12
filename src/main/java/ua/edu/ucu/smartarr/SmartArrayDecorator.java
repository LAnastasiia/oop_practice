package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;
    protected StringBuilder modifications;

    // is smartArray and has smartArray
    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
        this.modifications = new StringBuilder(" ");
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return this.modifications.toString();
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }

}
