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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid=findMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return Merge(left,right);
    }
    public ListNode Merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=null;
        if(l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }else{
            head=l2;
            l2=l2.next;
        }
        ListNode tail=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        while(l1!=null){
            tail.next=l1;
            l1=l1.next;
            tail=tail.next;
        }
        while(l2!=null){
            tail.next=l2;
            l2=l2.next;
            tail=tail.next;
        }
        return head;
    }
    public ListNode findMid(ListNode l){
        ListNode start=l;
        ListNode end=l;
        ListNode prev=null;
        while(end!=null && end.next!=null){
            prev=start;
            start=start.next;
            end=end.next.next;
        }
        if(prev!=null) prev.next=null;
        return start;
    }
}