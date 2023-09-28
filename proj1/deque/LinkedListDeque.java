package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private class StuffNode {
        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
            // System.out.println(size);
        }
    }
    private StuffNode sentinel;
    private StuffNode last;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        last = sentinel.next;
        this.size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
        last = sentinel.next;
        sentinel.prev = sentinel.next.next;
        size = 1;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        if (size == 0) {
            last = sentinel.next;
        }
        sentinel.prev = last;
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        last.next = new StuffNode(last, item, sentinel);
        last = last.next;
        sentinel.prev = last;
        size = size + 1;
    }

    @Override
    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        } else{
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StuffNode p = sentinel.next;
        while (sentinel.next != sentinel) {
            System.out.print(sentinel.next.item + " ");
            sentinel.next = sentinel.next.next;
        }
        sentinel.next = p;
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }else {
         T p = sentinel.next.item;
         sentinel.next = sentinel.next.next;
         size = size - 1;
         return p;
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        else {
            T p = last.item;
            last = last.prev;
            size = size - 1;
            return p;
        }
    }

    @Override
    public T get(int index){
        StuffNode p = sentinel.next;
        if (index > size) {
            return null;
        } else {
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return getRecursive_helper(index, sentinel.next);
    }

    private T getRecursive_helper(int index, StuffNode p) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursive_helper(index - 1, p.next);
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int pos;

        public LinkedListIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            StuffNode return_node = sentinel;
            pos = pos + 1;
            for (int i = 0; i < pos; i = i + 1) {
                return_node = return_node.next;
            }
            return return_node.item;
        }

    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        if (o instanceof LinkedListDeque == false) {
            return false;
        }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i = i + 1) {
            if (! other.get(i).equals(this.get(i))) {
                return false;
            }
        }
            return true;
    }
}







