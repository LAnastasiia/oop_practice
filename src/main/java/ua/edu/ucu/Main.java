package ua.edu.ucu;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        MyPredicate pr = new MyPredicate() {
//            @Override
//            public boolean test(Object t) {
//                return ((Integer) t) > 0;
//            }
//        };
//
//        MyComparator cmp = new MyComparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return ((Integer) o1) - ((Integer) o2);
//            }
//        };
//
//        MyFunction func = new MyFunction() {
//            @Override
//            public Object apply(Object t) {
//                return 2 * ((Integer) t);
//            }
//        };

        // Input: [-1, 2, 0, 1, -5, 3]
//        Integer[] integers = {-1, 2, 0, 1, -5, 3};
//        SmartArray sa = new BaseArray(integers);
//
////        sa = new DistinctDecorator(sa);
//
//        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
//        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
//        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]
//
//
//        // Alternative
////        sa = new MapDecorator(
////                    new SortDecorator(
////                        new FilterDecorator(sa, pr),
////                    cmp),
////                func);
//        Object[] result = sa.toArray();
//
//        for (Object el:result) {
//            System.out.println(el);
//        }
//        System.out.println(Arrays.copyOf(result, result.length, Integer[].class));

        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};

        SmartArray smart_arr_students = new BaseArray(students);

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student t1 = (Student) t;
                return (t1.getYear() == 2) && (t1.getGPA() >= 4.0) ;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student so1 = (Student) o1, so2 = (Student) o2;
                return (so1.getSurname()).compareTo(so2.getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student st = (Student) t;
                return st.getSurname() + st.getName();
            }
        };

        smart_arr_students = new DistinctDecorator(smart_arr_students);
        smart_arr_students = new FilterDecorator(smart_arr_students, pr);
        smart_arr_students = new SortDecorator(smart_arr_students, cmp);
        smart_arr_students = new MapDecorator(smart_arr_students, func);

        Object[] resul = smart_arr_students.toArray();
        for (Object el:resul) {
            System.out.println(el);
        }
//        return Arrays.copyOf(resul, resul.length, String[].class);
    }

}