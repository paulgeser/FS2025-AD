package ch.hslu.ad.sw03.ex6;

public class Number extends Node<Integer> {

    public Number(int value) {
        super(value);
        super.setLeft(null);
        super.setRight(null);
    }

    @Override
    public Integer eval() {
        return super.getData();
    }

    @Override
    public String compileText(){
        return "LOAD" + this.getData();
    }
}
