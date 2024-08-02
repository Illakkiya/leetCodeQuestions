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
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
class DoubleLinkedListNumber {
    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverse(head);
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        ListNode curr = reversed;
        int carry =0;
        int sum =0;

        while(curr!=null || carry >0){
            sum = carry + (curr!=null?curr.val*2:0);
            carry = sum/10;
            result.next =  new ListNode(sum%10);
            result = result.next;
            if(curr!=null)curr = curr.next;
        }
        return reverse(dummy.next);

    }
    public ListNode reverse(ListNode root){
        ListNode prev = null;
        ListNode curr= root;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode number = new ListNode(5);
        number.next = new ListNode(9);
        DoubleLinkedListNumber obj = new DoubleLinkedListNumber();
        ListNode out = obj.doubleIt(number);
        while (out!=null){
            System.out.print(out.val);
            out = out.next; // Advance the pointer to avoid an infinite loop

        }
    }
}