package ch.hslu.ad.sw02.ex1;

public class Liste<T> {

    private Node<T> head = null;

    public Liste() {
    }

    public void add(T data) {
        if (this.head == null) {
            this.head = new Node<T>(null, data);
        } else {
            this.head = new Node<T>(head, data);
        }
    }

    public int size() {
        if (this.head == null) {
            return 0;
        } else {
            return this.head.size();
        }
    }

    public boolean checkExist(T data) {
        if (this.head == null) {
            return false;
        }
        return this.head.checkExist(data);
    }

    public T getFirstAndRemove() {
        return this.getByIndexAndRemove(0, true);
    }

    public T getByIndexAndRemove(int index, boolean delete) {
        if (this.head == null) {
            return null;
        }
        int size = this.size();
        if (index >= size) {
            return null;
        }
        index = size - index - 1;
        boolean deleteLast = false;
        if (index == 0) {
            deleteLast = true;
        }
        T data = this.head.getByIndexAndDelete(index,delete);
        if (deleteLast) {
            this.head = this.head.getNextElement();
        }
        return data;
    }

    public T getByIndex(int index) {
        return this.getByIndexAndRemove(index, false);
    }
}
