package com.uncommonlyused.designpattern.gongchang05.test;

import com.uncommonlyused.designpattern.gongchang05.impl.StudentWorkFactory;
import com.uncommonlyused.designpattern.gongchang05.impl.TeacherWorkFactory;
import com.uncommonlyused.designpattern.gongchang05.interface_.IWorkFactory;

public class Test {
	public static void main(String[] args) {
        IWorkFactory studentWorkFactory = new StudentWorkFactory();
        studentWorkFactory.getWork().doWork();
        IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
        teacherWorkFactory.getWork().doWork();
    }
}
