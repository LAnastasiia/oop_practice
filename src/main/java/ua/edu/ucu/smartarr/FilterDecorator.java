package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;
import java.util.ArrayList;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{

    private MyPredicate predicate;

    public FilterDecorator (SmartArray smart_arr, MyPredicate pr){
        super(smart_arr);
        this.predicate = pr;
        ArrayList<Object> new_arr = new ArrayList<>();
        Object[] initial_arr = this.toArray();
        for (int i = 0; i < this.size(); i++)
            if (this.predicate.test(initial_arr[i])) {
                new_arr.add(initial_arr[i]);
            }
        this.smartArray = new BaseArray(new_arr.toArray());
        this.modifications.append(" -- filtered by MyPredicate ");
    }

}
