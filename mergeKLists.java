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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode list : lists){
            result = merge(result, list);
        }
        
        return result.next;
    }
    
    private ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();
        ListNode tempResult = dummy;
        
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                dummy.next = list2;
                list2 = list2.next;
            }
            else{
                dummy.next = list1;
                list1 = list1.next;
            }
            dummy = dummy.next;
        }
        
        if(list1 != null){
            dummy.next = list1;    
        }
        if(list2 != null) {
            dummy.next = list2;
        }
        
        return tempResult.next; 
    }
}