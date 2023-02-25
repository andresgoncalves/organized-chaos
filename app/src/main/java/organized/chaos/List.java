package organized.chaos;

import java.util.Objects;

/**
 * Plantilla de Lista Enlazada de tipo T
 * @see ListNode
 * @author Andres
 */
public class List<T> {
    private ListNode<T> first, last;
    private int size;
    
    /**
     * Agrega un elemento al final de la lista
     * @param value elemento a agregar
     */
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
    
    /**
     * Busca y elimina un elemento de la lista, y retorna su valor
     * @param value elemento a eliminar
     * @return El valor del elemento eliminado, o {@code null} si no se encontró
     * @see compareKey
     */
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
    
    /**
     * Elimina el elemento en la posición {@code index} y retorna su valor
     * @param index índice del elemento en la lista
     * @return El valor del elemento encontrado
     * @throws IndexOutOfBoundsException si el índice no está en el rango de la lista
     */
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
    
    /**
     * Retorna el elemento en la posición {@code index}
     * @param index índice del elemento en la lista
     * @return El valor del elemento encontrado
     * @throws IndexOutOfBoundsException si el índice no está en el rango de la lista
     */
    public T at(int index) {
        int i = 0;
        for(ListNode<T> node = first; node != null; node = node.getNext()) {
            if(index == i++) {
                return node.getValue();
            }
        }
        throw new IndexOutOfBoundsException(index);
    }
    
    /**
     * Busca un elemento de la lista, y retorna su valor
     * @param value elemento a buscar
     * @return El valor del elemento encontrado, o {@code null} si no se encontró
     * @see compareKey
     */
    public T find(Object value) {
        for(ListNode<T> node = first; node != null; node = node.getNext()) {
            if(compareKey(node.getValue(), value)) {
                return node.getValue();
            }
        }
        return null;
    }

    /**
     * Retorna el primer nodo de la lista
     * @return Primer nodo de la lista
     */
    public ListNode<T> getFirst() {
        return first;
    }


    /**
     * Retorna el último nodo de la lista
     * @return Último nodo de la lista
     */
    public ListNode<T> getLast() {
        return last;
    }

    /**
     * Retorna el tamaño de la lista
     * @return Tamaño de la lista
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Indica si la lista está vacía
     * @return {@code true} si la lista está vacía, si no {@code false}
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Compara un elemento de la lista con un objeto
     * @param a elemento de la lista
     * @param b objeto a comparar
     * @return @return {@code true} si los objetos coinciden, si no {@code false}
     */
    protected boolean compareKey(T a, Object b) {
        return Objects.equals(a, b);
    }
}
