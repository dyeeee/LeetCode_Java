package 剑指35_复制复杂链表_链表;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    // 复制一个链表。普通的复制就是遍历加新的节点。
    // 但是这题每个节点都带一个随机几点。 普通的思路是用一个额外的来存，遍历两次
    public Node copyRandomList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 对每个对应cur的新节点，设置为对应的新next/random
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }


    public Node copyRandomList2(Node head) {
        if(head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;  //后面会动的就先去指向
            cur.next = tmp;
            cur = tmp.next;  //移动
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)  //如果是null本来也默认是
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 交错拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        Node n1 = new Node(3);
        Node n2 = new Node(3);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        n1.random = null;
        n2.random = n1;
        n3.random = null;

        Node cur = n1;

        while (cur != null){
            System.out.print(cur.val + ", ");
            if (cur.random != null){
                System.out.println(cur.random.val);
            }else{
                System.out.println("null");
            }
            cur = cur.next;
        }

        System.out.println("复制");
        Node r = sol.copyRandomList(n1);

        while (r != null){
            System.out.print(r.val + ", ");
            if (r.random != null){
                System.out.println(r.random.val);
            }else{
                System.out.println("null");
            }

            r = r.next;
        }
    }
}
