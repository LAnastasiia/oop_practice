package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smart_arr){
        super(smart_arr);
        ArrayList<Object> new_arr = new ArrayList<>();
        Object[] initial_arr = this.toArray();
        for (int i = 0; i < this.size(); i++) {
            boolean repeated = false;
            for (int j = 0; j < i; j++) {
                if (initial_arr[i].equals(initial_arr[j])){
                    repeated = true;
                }
            }
            if (!repeated){
                new_arr.add(initial_arr[i]);
            }
        }
        this.smartArray = new BaseArray(new_arr.toArray());
        this.modifications.append(" -- repeated elements removed");
    }

}
