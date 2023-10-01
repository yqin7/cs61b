# cs61b

I spent two weeks completing the Double Ended Queue. Unlike the Single Ended Queue, the main change in the Double Ended Queue is that it can recognize the previous and next nodes of each node. Also, when performing add and remove operations, there is no need to loop through the entire linked list.

**LinkedListDeque:** The main focus is to understand the structure of the entire table and to complete the add and remove operations with as concise code as possible. The characteristic of LinkedListDeque is that it has a sentinel node, and the entire linked list is circular. The role of this sentinel node is to ensure that there are no special cases when performing add and remove operations. That is, we don't need to discuss when the length of the linked list is 0, adding a new node requires special consideration of which parameters to adjust.

When constructing a new empty LinkedListDeque, the main task is to construct a sentinel node. This sentinel node is no different from ordinary nodes in terms of parameters. Both have prev and next, meaning they know what the previous and next nodes are. We also need to know the first and last nodes. In an empty linked list, both the first and last nodes are the sentinel itself.

If we add a second node, we can use the addFirst and removeFirst methods. The results of these two methods are the same at present. In the addFirst method, the parameters we need to change are the first node (sentinel.next), the prev of the previous node (sentinel.next.next.prev), and the last node last (sentinel.prev). The last node will change when the original linked list length is 0 and will not change when the length is not 0. Similarly, the construction method of the addLast method is similar to addFirst, mainly updating the last node and the sentinel node's prev. After executing the two add methods, the size needs to be changed.

The two Remove methods are relatively more complicated than add and also need to return the removed value. First, we need to know the value of the first or second node, and then change the first or last node. After completing the above steps, we also need to change the prev of the new first node or the next of the last node, both of which point to the sentinel node. We also need to change last and sentinel.prev. Finally, the length of the linked list should be reduced by 1.

The implementation of the Get method relies on a for loop or recursive loop. The For loop is relatively easy, just create an internal parameter p node pointing to the first node, and then loop through it one by one using next. The recursive method is relatively more complicated. We need to construct a helper method to help us advance each node.

The Iterator mainly writes methods in LinkedListIterator and overrides the hasNext() and Next() methods of Java's built-in Iterator.

The Equal method is relatively simple, mainly using the previous get method to compare whether the values of each node are the same. Note the difference between Java and Python. Java mainly relies on .equals() to compare whether two values are the same. Python uses ==. In Java, == compares the addresses of the two numbers, not the values.



**ArrayDeque:** Unlike LinkedListDeque, ArrayDeque relies on an Array to complete the linked list. The advantage of the Array is that the running speed of the get method will be faster because it does not need to loop through the entire linked list. The code of ArrayDeque is relatively more complicated.

Whether it's addFirst or removeFirst, we need to be aware that if the size of the linked list is greater than the length of the linked list, we need to resize the entire array. Java does not allow the array to be stretched directly, so we can only construct a new array temporarily, copy the old array over, and then cover the old array with the new array. We call this step resize. Each time you resize, the length of the new array is twice the old one. When copying the array, we need to know the first and last values of the array. I chose to copy in batches, that is, first copy the first value to the last value of the old array, and then copy the rest. We also need to change nextFirst and nextLast.

Both removeFirst and removeLast methods need to resize when the effective array only accounts for 25% of the entire array. I divided this resize into two situations. One is that the order in the original array is continuous, and the other is that the values are concentrated at both ends, and the middle is all null. The first situation is relatively easy to handle, just copy the array once, and the second situation requires copying twice. And you have to calculate nextFirst and nextLast.

In ArrayDeque, I added two private methods myself: firstIndexCalculate and lastIndexCalculate. Their role is still significant and can avoid a lot of duplicate code. Because in ArrayDeque, after completing the operation, you always need to calculate the first and last values.

Iterator and equal are similar to LinkedListDeque, the main difference is that the iterator in ArrayDeque needs to track the first index.

In the Test, I mainly verified the accuracy of the code through a large number of random tests. That is, use a for loop to perform a large number of random operations, add or delete random values, and observe whether an error is reported during code execution.


The interface Deque is the superclass of ArrayDeque and LinkedListDeque. The main function is that when we create a new Deque method, we don't need to write duplicate code.


MaxArrayDeque is a subclass of ArrayDeque, mainly adding the use of Comparator. When constructing a comparator, you need to import java.util.Comparator; Comparator can be understood as an object, which contains a compare method.
