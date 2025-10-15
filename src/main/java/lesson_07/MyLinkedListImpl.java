package lesson_07;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedListImpl implements MyLinkedList {

    private Node head;

    private int size = 0;


    private static class Node {

        private int value;

        private Node nextNode;


        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int value) {
        size ++;
        Node newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        }
        else {
            Node node = head;

            while (node.getNextNode() != null) {
                node = node.getNextNode();
            }
            node.setNextNode(newNode);
        }
    }

    @Override
    public void add(int index, int value) {
        Node node = getNodeByIndex(index);
        if (node != null) {
            int oldValue = node.getValue();
            Node nextNode = node.getNextNode();
            Node newNode = new Node(oldValue, nextNode);
            node.setNextNode(newNode);
            node.setValue(value);
            return;
        }
        System.out.println("index passt nicht!");
    }

    @Override
    public int get(int index) {
        Node node = getNodeByIndex(index);
        if (node != null) {
            return node.getValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void set(int index, int value) {
        Node node = getNodeByIndex(index);
        if (node != null) {
            node.setValue(value);
            return;
        }
        System.out.println("Index passt nicht!");
    }

    private Node getNodeByIndex(int index) {
        if (index < size() && index >= 0) {
            Node node = head;
            for (int i = 0; i < index; i ++) {
                node = node.getNextNode();
            }
            return node;
        }
        return null;
    }

    @Override
    public boolean contains(int value) {
        Node node = head;

        while (node != null) {
            if (node.getValue() == value)
                return true;
            node = node.getNextNode();
        }

        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Iterator<Integer> backward() {
        return null;
    }

    @Override
    public Iterator<Integer> smallToBig() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public String toString() {
        String s = "[";
        Node node = head;

        while (node != null) {
            s += node.getValue();
            node = node.getNextNode();
            if (node != null)
                s += ", ";
        }

        s += "]";
        return s;
    }
}















































