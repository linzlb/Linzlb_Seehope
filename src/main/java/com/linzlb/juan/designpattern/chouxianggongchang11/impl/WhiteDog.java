package com.linzlb.juan.designpattern.chouxianggongchang11.impl;

import com.linzlb.juan.designpattern.chouxianggongchang11.interface_.IDog;
/*
 * Product
 * 产品的具体实现
 */
public class WhiteDog implements IDog {
    public void eat() {
        System.out.println("The white dog is eating!");
    }
}