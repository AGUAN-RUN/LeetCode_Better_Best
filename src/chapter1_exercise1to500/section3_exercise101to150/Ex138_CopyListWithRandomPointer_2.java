package chapter1_exercise1to500.section3_exercise101to150;

import java.util.HashMap;
import java.util.Map;

/*A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.


Constraints:
-10000 <= Node.val <= 10000
Node.random is null or pointing to a node in the linked list.
Number of Nodes will not exceed 1000.
*/
public class Ex138_CopyListWithRandomPointer_2 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //别人的写法
    //设置一个成员变量，递归算法
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val);
        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        return node;
    }

}
