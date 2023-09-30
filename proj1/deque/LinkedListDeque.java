package deque;

import java.util.Iterator;

/* If implements Iterable, we must have a iterator method. */
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class StuffNode {
        StuffNode prev;
        T item;
        StuffNode next;

        StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
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

//    public LinkedListDeque(T x) {
//        sentinel = new StuffNode(null, null, null);
//        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
//        last = sentinel.next;
//        sentinel.prev = sentinel.next.next;
//        size = 1;
//    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        last = sentinel.prev;
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        last.next = new StuffNode(last, item, sentinel);
        last = last.next;
        sentinel.prev = last;
        size = size + 1;
    }

//    @Override
//    public boolean isEmpty() {
//        return sentinel.next == sentinel;
//    }

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
        } else {
            T p = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            last = sentinel.prev;
            size = size - 1;
            return p;
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T p = last.item;
            last = last.prev;
            last.next = sentinel;
            sentinel.prev = last;
            size = size - 1;
            return p;
        }
    }

    @Override
    public T get(int index) {
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
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, StuffNode p) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursiveHelper(index - 1, p.next);
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int pos;

        LinkedListIterator() {
            pos = 0;
        }
        @Override
        public boolean hasNext() {
            return pos < size;
        }
        @Override
        public T next() {
            StuffNode returnNode = sentinel;
            pos = pos + 1;
            for (int i = 0; i < pos; i = i + 1) {
                returnNode = returnNode.next;
            }
            return returnNode.item;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> other = (Deque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i = i + 1) {
            if (!(other.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }
}







