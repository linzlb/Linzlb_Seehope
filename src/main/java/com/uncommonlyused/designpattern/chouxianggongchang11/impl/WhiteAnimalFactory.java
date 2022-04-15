package com.uncommonlyused.designpattern.chouxianggongchang11.impl;

import com.uncommonlyused.designpattern.chouxianggongchang11.interface_.IAnimalFactory;
import com.uncommonlyused.designpattern.chouxianggongchang11.interface_.ICat;
import com.uncommonlyused.designpattern.chouxianggongchang11.interface_.IDog;
/*
 * ConcreteFactory 
 * 具体工厂，创建具有特定实现的产品对象
 */
public class WhiteAnimalFactory implements IAnimalFactory {
	@Override
    public ICat createCat() {
        return new WhiteCat();
    }
   @Override
   public IDog createDog() {
        return new WhiteDog();
    }
}
