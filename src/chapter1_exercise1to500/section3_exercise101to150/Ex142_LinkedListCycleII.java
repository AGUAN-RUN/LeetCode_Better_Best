package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;

import java.util.HashMap;
import java.util.Map;

/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
Note: Do not modify the linked list.

Follow-up:
Can you solve it without using extra space?
*/
public class Ex142_LinkedListCycleII {
    //两个对象  用  == 比较的是对象的内存地址，A==B为true则A和B是同一个对象
    //使用一个map辅助求解

    //力扣上提出能否在空间上优化的题，往往使用空间和不使用空间的最优解的时间复杂度是一致的，不存在时间换空间的情况
    public ListNode detectCycle(ListNode head) {
        //用时5ms 击败28.38的用户
        Map<ListNode,Integer> mps=new HashMap<>();
        while(head!=null){
            if(mps.get(head)!=null&&mps.get(head)==1){
                return head;
            }else {
                mps.put(head,1);
                head=head.next;
            }
        }
        return null;
    }
}
