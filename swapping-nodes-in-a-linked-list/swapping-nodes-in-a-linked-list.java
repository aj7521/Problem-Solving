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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode next = head;
        while(k>1){
            if(next==null) return head;
            next = next.next;
            k--;
        }
        ListNode prev = head;
        ListNode cur = next;
        while(next.next!=null){
            next = next.next;
            prev = prev.next;
        }
        int temp = cur.val;
        cur.val = prev.val;
        prev.val = temp;
        return head;
    }
}