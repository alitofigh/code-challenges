package challenges;

import challenges.difination.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ali Tofigh 4/7/2022 10:48 AM
 */

public class SortList {

    public static void main(String[] args) {
        //sortList(new ListNode(10, new ListNode(4, new ListNode(8))));
        ListNode listNode = sortList2(new ListNode(10, new ListNode(4, new ListNode(8))));
    }

    public static ListNode sortList(ListNode head) {
        if (head.next == null)
            return head;
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode thirdNode = head.next.next;

        while (head.next != null) {
            if (head.val > head.next.val) {
                head.next = head.next.next;
                head.next = head;
            }
            head = head.next;
        }
        return firstNode;
    }

    public static ListNode sortList2(ListNode head) {
        if (head.next == null)
            return head;
        List<Integer> num = new ArrayList<>();
        do {
            num.add(head.val);
            head = head.next;
        } while (head != null);
        List<Integer> sortedNum = num.stream().sorted().collect(Collectors.toList());
        ListNode res = new ListNode(1);
        ListNode res2 = res;
        for (int i:sortedNum) {
            res2.next = new ListNode(i);
            res2 = res2.next;
        }
        return res.next;
    }
}
