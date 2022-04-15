package com.uncommonlyused.designpattern.ChainOfResponsibility20.impl;

import com.uncommonlyused.designpattern.ChainOfResponsibility20.AbstractRequest;
import com.uncommonlyused.designpattern.ChainOfResponsibility20.Lever;

//具体请求类03
public class Request03 extends AbstractRequest {
	public Request03(String content) {  
        super(content);  
    }

	@Override
	public int getRequestLevel() {
		// TODO Auto-generated method stub
		return Lever.LEVEL_03;
	} 
}