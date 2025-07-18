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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(-1);
        ListNode dummy=temp;
        ListNode a=l1;
        ListNode b=l2;
        int carry=0;
        while(a!=null || b!=null){
            int val1= (a!=null) ? a.val : 0;
            int val2= (b!=null) ? b.val : 0;
            int ans= val1+val2+carry;
            carry=ans/10;
            ans=ans%10;
            dummy.next=new ListNode(ans);
            dummy=dummy.next;
            if(a!=null) a=a.next;
            if(b!=null) b=b.next;
        }
        if(carry>0) dummy.next=new ListNode(carry);
        return temp.next;
    }
}