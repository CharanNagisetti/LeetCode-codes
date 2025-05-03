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
    public void reorderList(ListNode head) {
        ListNode start=head;
        ListNode end=head;
        while(end!=null && end.next!=null && end.next.next!=null){
            start=start.next;
            end=end.next.next;
        }
        ListNode prev=null, curr=start.next;
        ListNode temp;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        start.next=null;
        ListNode first=head;
        ListNode second=prev;
        while(second!=null){
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next = temp1;
            first=temp1;
            second=temp2;
        }
    }
}