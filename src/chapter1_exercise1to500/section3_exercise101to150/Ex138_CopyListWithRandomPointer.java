package chapter1_exercise1to500.section3_exercise101to150;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

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
public class Ex138_CopyListWithRandomPointer {
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
    //0ms  击败100%
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Map<Node,Node>ntn=new HashMap<>();
        Node temp=head;
        Node newNode=new Node(head.val);
        Node result=newNode;
        Node newNodeTemp=null;
        ntn.put(temp,newNode);
        while(temp.next!=null){
            temp=temp.next;
            newNodeTemp=newNode;
            newNode=new Node(temp.val);
            ntn.put(temp,newNode);
            newNodeTemp.next=newNode;
        }
        temp=head;
        Node random=null;
        while(temp!=null){
            newNodeTemp=ntn.get(temp);
            random=ntn.get(temp.random);
            newNodeTemp.random=random;
            temp=temp.next;
        }
        return result;
    }

}
