package organized.chaos;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public class List<T> {
    private ListNode<T> first, last;
    private int size;
    
    public ListNode<T> append(T value) {
        ListNode<T> node = new ListNode(value);
        if(size == 0) {
            first = last = node;
        }
        else {
            last.setNext(node);
            last = node;
        }
        size += 1;
        return node;
    }
    
    public void remove(Object value) {
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
                break;
            }
        }
    }
    
    public ListNode<T> find(Object value) {
        for(ListNode<T> node = first; node != null; node = node.getNext()) {
            if(compareKey(node.getValue(), value)) {
                return node;
            }
        }
        return null;
    }
    
    protected boolean compareKey(T a, Object b) {
        return Objects.equals(a, b);
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
}
