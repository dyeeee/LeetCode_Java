package LC82_83_删除排序链表中的重复元素;

//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]

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

class Solution {
    // 保留重复的元素 LC83
    public ListNode deleteDuplicates_keep(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while(cur !=null && cur.next != null){
            System.out.println("当前节点：");
            System.out.println(cur.val);
            if(cur.next != null && cur.next.val == cur.val){
                ListNode tmp = cur.next;
                System.out.println("找到了相同的节点");
                System.out.println(tmp.val);
                System.out.println(cur.val);

                while(tmp != null && tmp.val == cur.val){
                    System.out.println("寻找下一个不同点");
                    tmp = tmp.next;
                }
                cur.next = tmp;
                cur = cur.next;
            }else
            {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        // 虚拟节点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {

            if (cur.next.val == cur.next.next.val) {
                //找到了重复的节点
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }//记录数值直到遍历到下一个数值的节点
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    ListNode printNode(ListNode head){
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        //最后返回虚拟节点的下一个结点即可
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode l5 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        s.deleteDuplicates_keep(l1);

        s.printNode(l1);
    }

}