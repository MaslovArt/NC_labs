package NC_lab1.myCollection;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.function.Predicate;

public class MyLinkedList<T> implements IMyCollection<T>, Iterable<T> {

    class ListNode<T> {
        private T value;
        private ListNode<T> next;

        public ListNode(T value) {
            this.value = value;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;
    private int count;

    public <T> MyLinkedList() {
        count = 0;
    }

    public T get(int index) {
        int currentInd = 0;
        ListNode<T> currentNode = head;

        while (currentInd++ < index) {
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }
    public T getFirst() {
        return head.value;
    }
    public T getLast(){
        return tail.value;
    }

    @Override
    public void add(T item) {
        ListNode<T> newNode = new ListNode<>(item);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean remove(T item) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            if(current.value.equals(item)){
                if(previous == null) {
                    head = head.next;
                    if(head == null)
                        tail = null;
                }
                else {
                    previous.next = current.next;
                    if(current.next == null)
                        tail = previous;
                }
                count--;
                return true;
            }

            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(T obj) {
        ListNode<T> node = head;
        while (node != null) {
            if(node.value.equals(obj))
                return true;
            node = node.next;
        }
        return false;
    }

    public T find(Predicate<T> predicate) {
        ListNode<T> current = head;
        while (current != null) {
            if(predicate.test(current.value))
                return current.value;
            current = current.next;
        }
        return null;
    }

    @Override
    public T[] toArray() {
        if(count == 0) return null;

        T[] arr = (T[]) Array.newInstance(head.value.getClass(), count);
        int index = 0;
        ListNode<T> currentNode = head;
        for (int i = 0; currentNode != null; i++, currentNode = currentNode.next) {
            arr[i] = currentNode.value;
        }
        return arr;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "[ size: " + count +
                " head: " + head.toString() +
                " tail: " + tail.toString() + "]";
    }

    @Override
    public Iterator<T> iterator() {
        return new myLinkedListIterator();
    }
    class myLinkedListIterator implements Iterator<T> {
        ListNode<T> currentNode = head;
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
        @Override
        public T next() {
            ListNode<T> node = currentNode;
            currentNode = currentNode.next;
            return node.value;
        }
    }
}
