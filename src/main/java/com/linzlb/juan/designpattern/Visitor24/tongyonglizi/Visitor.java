package com.linzlb.juan.designpattern.Visitor24.tongyonglizi;

public class Visitor implements IVisitor {  
  
    public void visit(ConcreteElement1 el1) {  
        el1.doSomething();  
    }  
      
    public void visit(ConcreteElement2 el2) {  
        el2.doSomething();  
    }  
}  