package ch.hslu.ad.sw03.ex7;

public class Demo {

    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("B");
        tree.insert("D");
        tree.insert("E");
        tree.insert("A");
        tree.insert("F");
        tree.insert("G");
        tree.insert("H");
        tree.insert("I");
        System.out.println(tree.toString());
        tree.balanceTreeByInorder();
        System.out.println(tree.toString());
    }
}
