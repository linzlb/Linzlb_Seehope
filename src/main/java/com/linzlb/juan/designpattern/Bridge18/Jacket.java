package com.linzlb.juan.designpattern.Bridge18;
//ConcreteImplementor  具体实现
public class Jacket extends Clothing {
    @Override
    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿马甲");
    }
}