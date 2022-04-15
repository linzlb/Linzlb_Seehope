package com.zasui.jdk5;
//枚举
public class Demo4 {
	public enum Sex {
		M,
		F,
		NO_M_F
	}

	public static void youAre( Sex sex ) {
		System.out.println( sex );
	}

	public static void main( String [] args ) throws Exception {
		Demo4.youAre( Sex.NO_M_F );
	}
}