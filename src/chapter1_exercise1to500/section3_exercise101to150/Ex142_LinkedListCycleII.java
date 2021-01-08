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
/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

说明：不允许修改给定的链表。

进阶：

你是否可以使用 O(1) 空间解决此题？
 

示例 1：



输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：



输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：



输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
 

提示：

链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引
* */
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
