package ch.hslu.ad.sw03.ex6;

import java.util.List;

public class Node<T> {

    private final T data;
    private Node<T> left = null;
    private Node<T> right = null;

    public Node(T data) {
        this.data = data;
    }

    public Node() {
        this.data = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T eval() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String symbol() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String compileText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public boolean emptyChildren() {
        return left == null && right == null;
    }



    public static String toStringRec(Node<Integer> node) {
        if (node != null) {
            if (node.emptyChildren()) {
                return node.getData().toString();
            } else {
                return "("
                        + toStringRec(node.getLeft())
                        + node.symbol()
                        + toStringRec(node.getRight())
                        + ")";
            }
        }
        return "";
    }

    public static void compile(Node<Integer> node, List<String> result) {
        if (node != null) {
            compile(node.getLeft(), result);
            compile(node.getRight(), result);
            result.add(node.compileText());
        }
    }
}
