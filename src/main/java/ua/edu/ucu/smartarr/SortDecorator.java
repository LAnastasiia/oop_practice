package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private MyComparator comparator;

    public SortDecorator(SmartArray smart_arr, MyComparator cmp){
        super(smart_arr);
        this.comparator = cmp;

        Object[] initial_arr = this.toArray();
        List <Object> arr = Arrays.asList(initial_arr);
        arr.sort(this.comparator);
        this.modifications.append(" -- sorted");

    }

    public void edit(){
        // using Insertion Sort
        ArrayList<Object> new_arr = new ArrayList<>();
        Object[] initial_arr = this.toArray();

        Object min_el = initial_arr[0];
        for (int i = 0; i < this.size(); i++) {
            for (int j = i; j < this.size(); j++) {
                if (comparator.compare(initial_arr[i], initial_arr[0]) < 0){
                    min_el = initial_arr[i];
            }
            new_arr.add(min_el);
            }
        }
        this.smartArray = new BaseArray(new_arr.toArray());
    }
}
