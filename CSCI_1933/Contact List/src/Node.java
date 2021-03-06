/**
 * Node class to be used to implement MyNodeList
 */

public class Node {
    // instance variables
    private Object data;
    private Node next;

    // constructors
    public Node() {}

    public Node(Object o) {
        data = o;
        next = null;
    }

    public Node(Object o, Node link) {
        data = o;
        next = link;
    }

    // selectors
    public Object getData() {
        return data;
    }

    public void setData(Object o) {
        data = o;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node link) {
        next = link;
    }
}