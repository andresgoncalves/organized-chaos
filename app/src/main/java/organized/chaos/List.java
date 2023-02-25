package organized.chaos;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public class List<T> {
    private ListNode<T> first, last;
    private int size;
    
    public void append(T value) {
        ListNode<T> node = new ListNode(value);
        if(size == 0) {
            first = last = node;
        }
        else {
            last.setNext(node);
            last = node;
        }
        size += 1;
    }
    
    public T remove(Object value) {
        for(ListNode<T> node = first, prev = null; node != null; prev = node, node = node.getNext()) {
            if(compareKey(node.getValue(), value)) {
                if(node == last) {
                    last = prev;
                }
                if(node == first) {
                    first = node.getNext();
                }
                else {
                    prev.setNext(node.getNext());
                }
                size -= 1;
                return node.getValue();
            }
        }
        return null;
    }
    
    public T removeAt(int index) {
        int i = 0;
        for(ListNode<T> node = first, prev = null; node != null; prev = node, node = node.getNext()) {
            if(index == i++) {
                if(node == last) {
                    last = prev;
                }
                if(node == first) {
                    first = node.getNext();
                }
                else {
                    prev.setNext(node.getNext());
                }
                size -= 1;
                return node.getValue();
            }
        }
        throw new IndexOutOfBoundsException(index);
    }
    
    public T at(int index) {
        int i = 0;
        for(ListNode<T> node = first; node != null; node = node.getNext()) {
            if(index == i++) {
                return node.getValue();
            }
        }
        throw new IndexOutOfBoundsException(index);
    }
    
    public T find(Object value) {
        for(ListNode<T> node = first; node != null; node = node.getNext()) {
            if(compareKey(node.getValue(), value)) {
                return node.getValue();
            }
        }
        return null;
    }

    public ListNode<T> getFirst() {
        return first;
    }

    public ListNode<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    protected boolean compareKey(T a, Object b) {
        return Objects.equals(a, b);
    }
}
