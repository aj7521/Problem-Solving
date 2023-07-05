/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int len = calLen(head);
        k = k % len;
        if(k==0) return head;
        ListNode cur = head;
        ListNode nxt = head;
        while(k>0){
            nxt = nxt.next;
            k--;
        }
        while(nxt.next!=null){
            cur = cur.next;
            nxt = nxt.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        nxt.next = head;

        return newHead;
    }

    public int calLen(ListNode head){
        int len = 0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
}