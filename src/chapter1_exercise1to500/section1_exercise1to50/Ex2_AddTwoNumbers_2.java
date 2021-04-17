package chapter1_exercise1to500.section1_exercise1to50;

import commons.ListNode;

public class Ex2_AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode result = null;
        ListNode n1 = l1;
        ListNode n2 = l2;
        int temp = 0;
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                temp += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                temp += n2.val;
                n2 = n2.next;
            }
            if (resultNode == null) {
                resultNode = new ListNode(temp % 10);
                result = resultNode;
            } else {
                result.next = new ListNode(temp % 10);
                result = result.next;
            }
            temp /= 10;
        }
        if (temp == 1)
            result.next = new ListNode(1);
        return resultNode;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
