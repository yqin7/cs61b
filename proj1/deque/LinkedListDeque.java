package deque;

public class LinkedListDeque<T> {
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

    public void addFirst(T item) {
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        if (size == 0) {
            last = sentinel.next;
        }
        sentinel.prev = last;
        size = size + 1;
    }

    public void addLast(T item) {
        last.next = new StuffNode(last, item, sentinel);
        last = last.next;
        sentinel.prev = last;
        size = size + 1;
    }

    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        } else{
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        while (sentinel.next != sentinel) {
            System.out.println(sentinel.next.item + " ");
            sentinel.next = sentinel.next.next;
        }
        System.out.println();
    }

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

    public T get(int index){
        StuffNode p = sentinel.next;
        if (index > size) {
            return null;
        } else {
            for (int i = 0; i < index + 1; i++) {
                p = p.next;
            }
        }
        return p.item;
    }
}







