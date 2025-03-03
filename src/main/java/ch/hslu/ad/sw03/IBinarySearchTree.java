package ch.hslu.ad.sw03;

import java.util.List;

public interface IBinarySearchTree<T> {

    void insert(T object);
    boolean contains(T object);
    void remove(T object);
    T search(T object);
    List<T> inOrderTraversal();
    void preOrderTraversal();
    void postOrderTraversal();
}
