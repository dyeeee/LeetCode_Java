package 链表_LC86_分隔链表;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//你应当 保留 两个分区中每个节点的初始相对位置。
//
//
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]

// 思路： 维护两个链表，一个比x小，一个比x大，都按顺序排
// 遍历后合并两个链表

public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        // 虚拟头节点

        ListNode small_head = new ListNode(-101);
        ListNode large_head = new ListNode(-102);

        ListNode small_cur = small_head;
        ListNode large_cur = large_head;

        ListNode cur = head;

        while(cur != null) {
            if (cur.val < x){
                small_cur.next = cur;
                small_cur = cur;
            }else {
                large_cur.next = cur;
                large_cur = cur;
            }
            cur = cur.next;
        }

        small_cur.next = large_head.next;
        large_cur.next = null;

        return small_head.next;
    }


    ListNode createList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;

        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);;
            cur = cur.next;
        }

        return head;
    }

    void printNode(ListNode head){
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }

     public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1,4,3,2,5,2};
        ListNode lt = s.createList(nums);


         ListNode result = s.partition(lt,3);



        s.printNode(result);
    }
}
