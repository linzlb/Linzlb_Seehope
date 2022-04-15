package com.uncommonlyused.designpattern.Iterator16;
//Aggregate
public interface List {
	Iterator iterator();
    Object get(int index);
    int getSize();
    void add(Object obj);
}
