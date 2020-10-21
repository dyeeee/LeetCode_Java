package 剑指25_合并两个有序的链表_链表;


//输入: 1->2->4, 1->3->4
//输出: 1->1->2->3->4->4

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    // 通过一个伪头节点优化代码,注意 l1 l2 本身就是指针
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }

        // 判断是否整体为空的也可以省略
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return result.next;
    }

    // 标准合并思路
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result;

        if (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                result = p1;
                p1 = p1.next;
            } else {
                result = p2;
                p2 = p2.next;
            }
        } else if (p1 != null && p2 == null) {
            return p1;
        } else if (p2 != null && p1 == null) {
            return p2;
        } else {
            return null;
        }

        ListNode resultPointer = result;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                resultPointer.next = p1;
                p1 = p1.next;
                resultPointer = resultPointer.next;

            } else {
                resultPointer.next = p2;
                p2 = p2.next;
                resultPointer = resultPointer.next;
            }

        }

        if (p1 != null) {
            resultPointer.next = p1;
        }
        if (p2 != null) {
            resultPointer.next = p2;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(1);
        L1.next = new ListNode(2);
        L1.next.next = new ListNode(4);

        ListNode L2 = new ListNode(1);
        L2.next = new ListNode(3);
        L2.next.next = new ListNode(4);

        ListNode L3 = null;

        Solution s = new Solution();
        ListNode r = s.mergeTwoLists(L3, L2);

        while (r != null) {
            System.out.print(r.val);
            r = r.next;
        }

    }
}
