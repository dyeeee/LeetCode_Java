package 剑指06_从尾到头打印链表_链表;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// 和24题一致
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode nullNode = null;
        ListNode pre = head;
        ListNode cur = nullNode;
        int length = 0;

        while(pre != null){
            ListNode tmp = pre;
            pre = pre.next;
            tmp.next = cur;
            cur = tmp;
            length ++;
        }

        int[] result = new int[length];
        for(int i=0;i<length;i++){
            result[i] = cur.val;
            cur = cur.next;
        }

        return result;

    }
}