package ch.hslu.ad.sw02.ex1;

public class Node<T> {
    private Node<T> nextElement;
    private T data;

    public Node(Node<T> nextElement, T data) {
        this.nextElement = nextElement;
        this.data = data;
    }

    public void setNextElement(Node<T> nextElement) {
        this.nextElement = nextElement;
    }

    public Node<T> getNextElement() {
        return nextElement;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int size() {
        if (nextElement == null) {
            return 1;
        } else {
            return 1 + nextElement.size();
        }
    }

    public boolean checkExist(T data) {
        if (data.equals(this.data)) {
            return true;
        } else if (nextElement != null) {
            return nextElement.checkExist(data);
        }
        return false;
    }

    public T getByIndexAndDelete(int index, boolean delete) {
        if (index == 1) {
            T data = this.nextElement.getData();
            if (delete) {
                this.nextElement = this.nextElement.getNextElement();
            }
            return data;
        } else if (index == 0) {
            return this.data;
        } else {
            index -= 1;
            return this.nextElement.getByIndexAndDelete(index, delete);
        }
    }
}
