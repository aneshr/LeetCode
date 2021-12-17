import java.util.ArrayList;
import java.util.List;

// * Definition for singly-linked list.
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> outPut = new ArrayList<>();

        int carry = 0;
        int size_1 = getSize(l1);
        int size_2 = getSize(l2);

        if(size_1 >= size_2){
            return(getSum(l1,l2));
        }
        else{
            return(getSum(l2,l1));
        }

    }
    public static ListNode getSum(ListNode l1, ListNode l2){
        // Assuming if size(l1) >= size(l2)

        ListNode res = new ListNode(0);
        ListNode outPut = res;
        int carry = 0;
        while(l2 != null){
            int intermidiateSum = 0 ;
            intermidiateSum = carry + l1.val + l2.val;
            carry = intermidiateSum>9?1:0;

            ListNode node = new ListNode(intermidiateSum%10);

            res.next = node;
            res=res.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int intermediate = carry + l1.val;
            ListNode node = new ListNode(intermediate%10);
            carry = intermediate>9?1:0;

            res.next = node;
            res = res.next;
            l1 = l1.next;

        }
        if(carry == 1){
            ListNode node = new ListNode(1);
            res.next = node;
        }

        return(outPut.next);

    }
    public static int getSize(ListNode ll){
        int size = 0;
        while(ll != null ){
            size++;
            ll = ll.next;
        }
        return(size);
    }
}