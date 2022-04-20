package challenges;

import challenges.difination.ListNode;

/**
 * @author Ali Tofigh 4/19/2022 10:03 AM
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 =
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result = addTwoNumbers(l1, l2);
        print(l1);
        print(l2);
        System.out.println("result: ");
        print(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode tmp = res;
        int d = 0;
        while (l1 != null) {
            if (l2 != null) {
                d = addResult(tmp, l1.val, l2.val, d);
                l1 = l1.next;
                l2 = l2.next;
            }  else {
                d = addResult(tmp, l1.val, 0, d);
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        if (l2 != null)
            while (l2 != null) {
                d = addResult(tmp, l2.val, 0, d);
                l2 = l2.next;
                tmp = tmp.next;
            }
        if (d == 1)
            addResult(tmp, 0, 0, 1);
        return res.next;
    }

    public static int addResult(ListNode res, int val1, int val2, int d) {
        int sum = val1 + val2 + d;
        d = 0;
        if (sum > 9) {
            d = 1;
            res.next = new ListNode(sum % 10);
        } else {
            res.next = new ListNode(sum);
        }
        return d;
    }


    static void print(ListNode l) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        while (l != null) {
            res.append(l.val).append(", ");
            l = l.next;
        }
        if (res.lastIndexOf(",") > 0)
            res.replace(res.lastIndexOf(","), res.lastIndexOf(",") + 1, "]");
        else
            res.append("]");
        System.out.println(res);
    }
}
