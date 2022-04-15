package com.uncommonlyused.designpattern.SimpleFactory01.service;

import com.uncommonlyused.designpattern.SimpleFactory01.Operation;
import com.uncommonlyused.designpattern.SimpleFactory01.factory.OperationFactory;

public class Test {
	public static void main(String[] args) {
		Operation operation = OperationFactory.createOperate("*");
		int result = operation.getResult(6, 3);
		System.out.println(result);
	}
}
