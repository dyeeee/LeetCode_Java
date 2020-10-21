package 剑指52_两个链表的第一个公共节点_双指针;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5],
// skipA = 2, skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，
// 链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；
// 在 B 中，相交节点前有 3 个节点。


// 双指针思路
// 公共长度为C，A的长度为L1+C、B的长度为L2+C
// 两个指针各自遍历一次，到空则指向另一条链表
// 第二次遍历相遇的节点为第一个公共节点（两个指针都走了L1+L2+C的长度）
// 如果链表长度相同且不相交会同时指向空结束循环，长度不相同则第二次遍历完同时指向空

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        while(p!=q){
            if(p!=null) {p = p.next;}
            else{p = headB;}
            if(q!=null) {q = q.next;}
            else{q = headA;}
        }
        return p;
    }
}