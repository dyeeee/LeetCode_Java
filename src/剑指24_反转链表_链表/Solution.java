package 剑指24_反转链表_链表;


//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    // 简洁优化的双指针
    // 思路，提前存好下一个就能往后跳
    public ListNode reverseList2(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null){
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return  cur;
    }


    public ListNode reverseList(ListNode head) {

        //注意边界条件
        if (head == null){
            return null;
        }
        else if(head.next == null){
            return head;
        }

        ListNode nullNode = null;
        ListNode p = head.next;
        ListNode q = head;
        ListNode back = p;
        head.next = nullNode;

        while (p.next != null) {
            p = p.next;
            back.next = q;
            q = back;
            back = p;
        }

        //注意最后一次没有改
        p.next = q;

        return p;
    }



}