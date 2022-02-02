package main.java.com.obinnaogbonna.practice.methodReference;

interface MyFunc<T> {
    int func(T[] vals, T v);
}

class MyArrayOps {
    <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for(T item : vals) {
            if(item == v) count++;
        }
        return count;
    }
}

public class GenericMethodRefDemo {

    static <T> int myOp(MyFunc<T> myFunc, T[] vals, T v) {
        return myFunc.func(vals, v);
    }

    public static void main(String args[]) {
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9};
        String[] strArr = {"One", "Two", "Two", "Three"};

        int intCount = myOp(new MyArrayOps()::<Integer>countMatching, intArr, 7);
        System.out.println("There are " + intCount + " 7s");

        int strCount = myOp(new MyArrayOps()::<String>countMatching, strArr, "Two");
        System.out.println("There are " + strCount + " Twos");
    }
    
}
