package com.ssu.elizaveta_ziborova.java.lesson5.task5;

import com.ssu.elizaveta_ziborova.java.lesson4.task4.DynamicArray;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Stream<Integer> st = Stream.empty();
        List<Integer> list = Stream.generate(()->new Random().nextInt(1000001)).limit(1000000).collect(Collectors.toList());//Создание
        List evenList = list.stream().filter((n)->n%2==0).collect(Collectors.toList());// Четные числа
        List oddList = list.stream().filter((n)->n%2==1).collect(Collectors.toList()); // Нечетные числа
        List doubleList = list.stream().map((n)->n*2).collect(Collectors.toList());// Удвоение всех чисел
        List distinctList = list.stream().distinct().collect(Collectors.toList()); // Повторения исчезают
        List sortedList = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());// По убыванию
        Integer integer = list.stream().mapToInt((s)->s).sum();


    }
}
