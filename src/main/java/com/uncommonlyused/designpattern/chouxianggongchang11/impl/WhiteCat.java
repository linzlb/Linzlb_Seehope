package com.uncommonlyused.designpattern.chouxianggongchang11.impl;

import com.uncommonlyused.designpattern.chouxianggongchang11.interface_.ICat;
/*
 * Product
 * 产品的具体实现
 */
public class WhiteCat implements ICat {
    public void eat() {
        System.out.println("The white cat is eating! ");
    }
}
