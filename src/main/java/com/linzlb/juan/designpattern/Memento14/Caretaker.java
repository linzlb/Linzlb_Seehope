package com.linzlb.juan.designpattern.Memento14;

public class Caretaker {
	private Memento memento;
    public Memento getMemento(){
        return this.memento;
    }
    public void setMemento(Memento memento){
        this.memento = memento;
    }
}
