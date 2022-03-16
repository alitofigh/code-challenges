package challenges;

/**
 * @author Ali Tofigh 3/15/2022 2:36 PM
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        //ListNode l1 = new ListNode(0, new ListNode(1, new ListNode(5)));
        //ListNode l2 = new ListNode(1, new ListNode(4, new ListNode(8)));
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        System.out.print("List 1: ");
        print(l1);
        System.out.print("List 2: ");
        print(l2);
        ListNode l3 = merge(l1, l2);
        System.out.println("Result: ");
        print(l3);
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

    static ListNode merged = null;
    private static ListNode merge(ListNode l1, ListNode l2) {
        if (getVal(l1) == -1)
            return l2;
        if (getVal(l2) == -1)
            return l1;
        ListNode result = merged;
        while (getVal(l1) != -1 || getVal(l2) != -1) {
            if (result == null)
                result = merged;
            if (getVal(l1) == -1) {
                while (getVal(l2) != -1) {
                    insert(getVal(l2));
                    l2 = l2.next;
                }
            } else if (getVal(l2) == -1) {
                while (getVal(l1) != -1) {
                    insert(getVal(l1));
                    l1 = l1.next;
                }
            } else {
                if (getVal(l1) <= getVal(l2)) {
                    insert(getVal(l1));
                    l1 = l1.next;
                } else{
                    insert(getVal(l2));
                    l2 = l2.next;
                }
            }
        }
        return result;
    }

    static int getVal(ListNode l) {
        if (l != null)
            return l.val;
        else return -1;
    }

    static void insert(int val) {
        if (merged == null) {
            merged = new ListNode(val);
        } else {
            merged.next = new ListNode(val);
            merged = merged.next;
        }
    }



    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
