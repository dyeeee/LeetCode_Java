package 剑指22_链表的倒数第K的节点_链表_双指针;

//给定一个链表: 1->2->3->4->5, 和 k = 2.
//        返回链表 4->5.

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    // 普通思路
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        int length = 1;
        while (p.next != null){
            p = p.next;
            length ++;
        }

        ListNode q = head;
        int loc = length - k + 1;
        for (int i = 0;i<loc;i++){
            q = q.next;
        }

        return q;
    }

    // 一边顺序遍历一边构建成反向链表
    // 有问题 输出顺序是反的
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode p = head.next;
        ListNode q = head;
        ListNode back = p;

        while (p != null){
            p = p.next;
            back.next = q;
            q = back;
            back = p;
        }

        ListNode end = q;

        for (int i=0;i<k-2;i++){
            end = end.next;
        }
        end.next = null;

        return p;
    }

    // 双指针/快慢指针的思路
    // 快指针先走k步，然后一起走到快指针到头
    public ListNode getKthFromEnd3(ListNode head, int k){
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        for (int i = 0;i<k;i++){
            firstPointer = firstPointer.next;
        }

        while (firstPointer != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return secondPointer;
    }




}