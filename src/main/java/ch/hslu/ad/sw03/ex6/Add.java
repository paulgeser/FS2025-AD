package ch.hslu.ad.sw03.ex6;

public class Add extends Node<Integer> {

    public Add(Node<Integer> leftNode, Node<Integer> rightNode) {
        super();
        super.setLeft(leftNode);
        super.setRight(rightNode);
    }
    
    @Override
    public Integer eval() {
        return super.getLeft().eval() + super.getRight().eval();
    }

    @Override
    public String symbol() {
        return "+";
    }

    @Override
    public String compileText(){
        return "ADD";
    }
}
