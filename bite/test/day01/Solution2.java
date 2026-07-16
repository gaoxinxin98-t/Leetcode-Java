package bite.test.day01;
import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        int numb1 = getInt(head1);
        int numb2 = getInt(head2);

        int sum = numb1 + numb2;

        return getListNode(sum);



    }

    private ListNode getListNode(int sum) {
        ListNode head = null;

        while (sum > 0) {
            ListNode tmpNode = new ListNode(sum % 10);
            tmpNode.next = head;
            head = tmpNode;
            sum /= 10;
        }
        return head;
    }

    private int getInt(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len*=10;
        }

        int sub = 1;

        while(len>=1) {
            sub = sub*len + head.val;
            head = head.next;
            len/=10;
        }

        return sub;
    }
}
