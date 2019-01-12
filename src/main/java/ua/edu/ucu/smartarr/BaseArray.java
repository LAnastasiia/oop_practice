package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

// Base array for decorators
public class BaseArray implements SmartArray{

    private Object[] arr;
    private String modifications;

    public BaseArray(Object[] input_obj_arr){
        this.arr = input_obj_arr;
        this.modifications = "Smart Array ";
    }

    public void edit(){}

    @Override
    public Object[] toArray() {
        return this.arr;
    }

    @Override
    public String operationDescription() {
        return this.modifications;
    }

    @Override
    public int size() {
        return this.arr.length;
    }
}
