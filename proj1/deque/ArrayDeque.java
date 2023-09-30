package deque;
import java.util.Iterator;


public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */   
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /** Inserts X into the front of the list. */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size = size + 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst = nextFirst - 1;
        }
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
        System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextFirst + 1);
        items = a;
        nextFirst = items.length - 1;
        nextLast = items.length / 2;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        size = size + 1;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast = nextLast + 1;
        }
    }

    /** Return if array is empty or not. */
//    @Override
//    private boolean isEmpty() {
//        return size == 0;
//    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last. */
    @Override
    public void printDeque() {
        int firstIndex = firstIndexCalculate();
        for (int i = 0; i < size; i++) {
            if (i + firstIndex < items.length) {
                System.out.print(items[i + firstIndex] + " ");
            } else {
                System.out.print(items[i + firstIndex - items.length] + " ");
            }
        }
        System.out.println();
    }

    /** Returns the item from the front of the list. */
    private T getFirst() {
        int firstIndex = firstIndexCalculate();
        return items[firstIndex];
    }

    /** Deletes item from front of the list and
     * returns deleted item. */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = getFirst();
        int firstIndex = firstIndexCalculate();
        nextFirst = firstIndex;
        items[firstIndex] = null;
        size = size - 1;
        if (size <= items.length * 0.25 && size > 8) {
            resizeDown(size);
        }
        return x;
    }

    private void resizeDown(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (items[0] != null && items[items.length - 1] != null) {
            System.arraycopy(items, firstIndexCalculate(), a, 0,
                    items.length - firstIndexCalculate());
            System.arraycopy(items, 0, a, items.length - firstIndexCalculate(),
                    size - (items.length - firstIndexCalculate()));
            items = a;
        } else {
            System.arraycopy(items, firstIndexCalculate(), a, 0, size);
            items = a;
        }
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    /** Returns the item from the back of the list. */
    private T getLast() {
        int lastIndex = lastIndexCalculate();
        return items[lastIndex];
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = getLast();
        int lastIndex = lastIndexCalculate();
        nextLast = lastIndex;
        items[lastIndex] = null;
        size = size - 1;
        if (size <= items.length * 0.25 && size > 8) {
            resizeDown(size);
        }
        return x;
    }
    
    /** Returns the 1st index. If nextFirst equal to items' length - 1, first index should be 0. */
    private int firstIndexCalculate() {
        if (nextFirst == items.length - 1) {
            return 0;
        } else {
            return nextFirst + 1;
        }
    }

    /** Returns the last index. If nextLast equal 0, last index should be items' length - 1. */
    private int lastIndexCalculate() {
        if (nextLast == 0) {
            return items.length - 1;
        } else {
            return nextLast - 1;
        }
    }

    /** Gets the ith item in the list (0 is the front).*/
    @Override
    public T get(int i) {
        if (i >= size) {
            return null;
        } else {
            int firstIndex = firstIndexCalculate();
            if (firstIndex + i < items.length) {
                return items[firstIndex + i];
            } else {
                return items[firstIndex + i - items.length];
            }
        }
    }

    /** Provide this method to return an iterator. */

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int pos;
        private int countPos;
        ArrayIterator() {
            pos = firstIndexCalculate();
            countPos = 0;
        }
        @Override
        public boolean hasNext() {
            return countPos < size;
        }
        public T next() {
            T returnItem = items[pos];
            countPos = countPos + 1;
            pos = dynamicFirstIndexCalculate();
            return returnItem;
        }
        private int dynamicFirstIndexCalculate() {
            if (pos == items.length - 1) {
                return 0;
            } else {
                return pos + 1;
            }
        }
    }

    /** Returns whether the parameter o is equal to the Deque. */
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
        for (int i = 0; i < size; i = i + 1) {
            if (!(other.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }
}

