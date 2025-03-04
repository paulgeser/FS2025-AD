package ch.hslu.ad.sw03.ex7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Musste ziemlich nichts geändert werden, da schon in EX5 der Baum vollkommen generisch implementiert wurde.
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

    private Node<T> root = null;
    private static final Logger LOG = LoggerFactory.getLogger(BinarySearchTree.class);


    public BinarySearchTree(Node<T> root) {
        this.root = root;
    }

    public BinarySearchTree() {
    }

    private Node<T> insertRecursive(Node<T> node, T value) {
        if (contains(value)) {
            throw new IllegalArgumentException("Value already exists");
        }
        if (node == null) {
            return new Node<T>(value);
        }
        if (value.compareTo(node.getData()) < 0) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRight(insertRecursive(node.getRight(), value));
        }

        return node; // Wurzel zurückgeben
    }


    @Override
    public void insert(T object) {
        root = insertRecursive(root, (T) object);
    }

    @Override
    public boolean contains(T object) {
        return this.search(object) != null;
    }

    @Override
    public void remove(T object) {

    }

    @Override
    public T search(T object) {
        return recursiveSearch(this.root, object);
    }

    public T recursiveSearch(Node<T> node, T object) {
        if (node == null) {
            return null;
        }
        if (node.getData().equals(object)) {
            return node.getData();
        } else {
            if (object.compareTo(node.getData()) < 0) {
                return recursiveSearch(node.getLeft(), object);
            } else if (object.compareTo(node.getData()) > 0) {
                return recursiveSearch(node.getRight(), object);
            }
            return null;
        }
    }

    @Override
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node<T> node, List<T> result) {
        if (node != null) {
            inOrderRec(node.getLeft(), result);
            result.add(node.getData());
            inOrderRec(node.getRight(), result);
        }
    }

    public void balanceTreeByInorder() {
        List<T> orderedList = this.inOrderTraversal();
        this.root = this.balanceTreeByInorderRecursive(orderedList);
    }

    private Node<T> balanceTreeByInorderRecursive(List<T> orderedList) {
        if (orderedList.isEmpty()) {
            return null;
        }
        int mid = orderedList.size() / 2;
        Node<T> node = new Node<T>(orderedList.get(mid));
        node.setLeft(balanceTreeByInorderRecursive(orderedList.subList(0, mid)));
        node.setRight(balanceTreeByInorderRecursive(orderedList.subList(mid + 1, orderedList.size())));
        return node;
    }

    @Override
    public void preOrderTraversal() {

    }

    @Override
    public void postOrderTraversal() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildTreeString(root, "", true, sb);
        return sb.toString();
    }

    private void buildTreeString(Node<T> node, String prefix, boolean isTail, StringBuilder sb) {
        if (node != null) {
            sb.append(prefix)
                    .append(isTail ? "└── " : "├── ")
                    .append(node.getData())
                    .append("\n");

            List<Node<T>> children = new ArrayList<>();
            if (node.getLeft() != null) children.add(node.getLeft());
            if (node.getRight() != null) children.add(node.getRight());

            for (int i = 0; i < children.size(); i++) {
                buildTreeString(children.get(i), prefix + (isTail ? "    " : "│   "),
                        i == children.size() - 1, sb);
            }
        }
    }

}
