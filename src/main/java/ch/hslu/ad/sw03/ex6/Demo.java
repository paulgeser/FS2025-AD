package ch.hslu.ad.sw03.ex6;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        Node<Integer> n = new Mul (
                new Add(new Number(2), new Number(3)),
                new Number(4)
        );
        System.out.println (n.eval());
        System.out.println (Node.toStringRec(n));
        List<String> data = new ArrayList<>();
        Node.compile(n, data);
        System.out.println (data);
    }
}
