package com.ssu.elizaveta_ziborova.java.lesson4.task4;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<T> implements Iterable<T>{
    private Object[] array;


    public DynamicArray( int size){
        array = new Object[size];
    }

    public void add(T t){
        int i=0;
        while(true){
            if (array[i]==null){
                array[i] = t;
                break;
            }
            i++;
        }
    }

    public T get(int index) {
        @SuppressWarnings("unchecked")
        final T t = (T)array[index];
        return t;
    }

    public void set(T t, int index){
        Object[] arrayHelp = new Object[array.length+1];
        int j = 0;
        for (int i =0; i < arrayHelp.length;i++){
            if (i==index){
                Array.set(arrayHelp, index,t);
                j++;
            } else{
                Array.set(arrayHelp, i,array[i-j]);
            }
        }
        array = arrayHelp;
    }

    public void remove(int index){
        Object[] arrayHelp = new Object[array.length-1];
        int j = 0;
        for (int i =0; i < arrayHelp.length;i++){
            if (i==index){
                j++;
            }
                Object n = array[i+j];
                Array.set(arrayHelp, i, n);
        }
        array = arrayHelp;
    }

    public void toString1() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i< array.length; i++){
            if(array[i]!=null)
                System.out.println("Index: "+i+" Element: "+array[i].toString()+"\n");
            else
                break;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}

class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(10);
        dynamicArray.add(1.45);
        dynamicArray.add(8.75);
        dynamicArray.add(4.3);
        dynamicArray.add(96.52);
        dynamicArray.add(1.855);
        dynamicArray.toString1();
        double m = (double)dynamicArray.get(2);
        dynamicArray.set(1.555,2);
        dynamicArray.remove(3);
        dynamicArray.toString1();

    }
}

