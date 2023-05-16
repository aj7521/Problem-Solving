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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev = head;
        ListNode cur = head.next;
        while(prev!=null && cur!=null){
            int temp = cur.val;
            cur.val = prev.val;
            prev.val = temp;
            prev = cur.next;
            if(prev!=null)  cur = prev.next;
        }
        return head;
    }
}