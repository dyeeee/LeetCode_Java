package 链表_LC147_对链表进行插入排序;

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

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        int min = Integer.MIN_VALUE;
        ListNode dummy = new ListNode(min,head);
        ListNode cur = dummy;
        ListNode pre = dummy;

        while (cur != null){

            if (cur.val < pre.val){
                pre.next = cur.next;
                // Insert
                ListNode insert = dummy;
                ListNode insert_pre = dummy;

                while (insert.val < cur.val){
                    insert_pre = insert;
                    insert = insert.next;
                }
                cur.next = insert_pre.next;
                insert_pre.next =cur;
                // Insert
                cur = pre.next;

//                printNode(pre);
            }
            else{
                pre = cur;
                cur = cur.next;
            }

        }

        return dummy.next;
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

        int[] nums = {-1,0,3,5,4};
        ListNode lt = s.createList(nums);

         ListNode result = s.insertionSortList(lt);

        s.printNode(result);
    }
}
