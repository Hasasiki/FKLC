package Node;

import org.junit.Test;

import java.util.HashSet;

public class RemoveDuplicateNodeLCCI {
    @Test
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int[] s = {1, 2, 3, 3, 2, 1};
        for (int i = 0; i < s.length; i++) {
            temp.val = s[i];
            temp.next = new ListNode();
            temp = temp.next;
        }
        removeDuplicateNodes(head);
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode listNodeSlow = head;
        ListNode listNodeFast = head;
        while(listNodeSlow != null){
            listNodeFast = listNodeSlow;
            while (listNodeFast.next != null){
                if (listNodeFast.next.val == listNodeSlow.val){
                    listNodeFast.next = listNodeFast.next.next;
                }else{
                    listNodeFast = listNodeFast.next;
                }
            }
            listNodeSlow = listNodeSlow.next;
        }
        return head;
    }
    public static ListNode removeDuplicateNodesInSet(ListNode head){
        ListNode current = head;
        ListNode prev = new ListNode();
        prev.next = head;
        HashSet<Integer> set = new HashSet<>();
        while (current!=null){
            if (!set.contains(current.val)) {
                set.add(current.val);
                prev = current;
            }else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return head;
    }
}
