package com.linzlb.juan.designpattern.SimpleFactory01.factory;

import com.linzlb.juan.designpattern.SimpleFactory01.Operation;
import com.linzlb.juan.designpattern.SimpleFactory01.OperationAdd;
import com.linzlb.juan.designpattern.SimpleFactory01.OperationDiv;
import com.linzlb.juan.designpattern.SimpleFactory01.OperationMul;
import com.linzlb.juan.designpattern.SimpleFactory01.OperationSub;

//后续改进！！！如果是使用反射去拿的话，那么以后就再也不用修改工厂了。
public class OperationFactory {
	public static Operation createOperate(String operate){
		if(operate == "+"){
			return new OperationAdd();
		}
		if(operate == "-"){
			return new OperationSub();
		}
		if(operate == "*"){
			return new OperationMul();
		}
		if(operate == "/"){
			return new OperationDiv();
		}
		return null;
	}
}
