package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.function.Function;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction function;

    public MapDecorator(SmartArray smart_arr, MyFunction func){
        super(smart_arr);
        this.function = func;

        ArrayList<Object> new_arr = new ArrayList<>();
        Object[] initial_arr = this.toArray();
        for (int i = 0; i < this.size(); i++) {
            new_arr.add(function.apply(initial_arr[i]));
        }
        this.smartArray = new BaseArray(new_arr.toArray());

        this.modifications.append(" -- mapped by MyFunction ");

    }

}
