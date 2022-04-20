package challenges;

import challenges.difination.TreeNode;

import javax.swing.text.StyledEditorKit;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ali Tofigh 4/10/2022 11:34 AM
 */

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode tree =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(7),
                                        new TreeNode(9)),
                                new TreeNode(3,
                                        new TreeNode(6),
                                        new TreeNode(5))),
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(5),
                                        new TreeNode(6)),
                                new TreeNode(4,
                                        new TreeNode(9),
                                        new TreeNode(7))
                        )
                );

        tree = new TreeNode(1,
                new TreeNode(5,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(3)),
                        null),
                new TreeNode(5,
                        null,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4))
                )
        );

        tree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(2),
                        null),
                new TreeNode(2,
                        new TreeNode(2),
                        null));

        //System.out.println(preOrder(tree));


        System.out.println("result: " + isSymmetric(tree));
        System.out.println("result: " + idddd(tree));
        //System.out.println(postOrder(tree));

        List<String> l1 = new ArrayList<>();
        l1.add("Ali");
        l1.add("Al");
        List<String> l2 = new ArrayList<>();
        l2.add("Al");
        l2.add("Ali");
        List<String> collect = l1.stream().filter(s -> (l2.stream().filter(s::equals).count()) < 1).collect(Collectors.toList());
        if (collect.size() > 0) {
            System.out.println("false");
        }

    }

    public static boolean isSymmetric(TreeNode tree) {
        if ((tree.left == null && tree.right != null)
                || (tree.left != null && tree.right == null))
            return false;
        inOrder(tree);
        String s = Arrays.toString(series.toArray());
        System.out.println(s);
        /*System.out.println(lvr);
        String p1 = lvr.substring(0, lvr.length() / 2);
        String p2 = lvr.substring(lvr.length() / 2 + 1);

        if (p1.length() != p2.length())
            return false;
        p2 = new StringBuilder(p2).reverse().toString();
        return p1.equals(p2);*/
        return true;


        /*boolean valid = true;
        for (int i = 0; i < p1.length(); i++) {
            if (p1.charAt(i) != p2.charAt(p2.length() - (i + 1))) {
                valid = false;
                break;
            }
        }

        return valid;*/
    }

    public static boolean idddd(TreeNode treeNode) {
        return isSymmetric(treeNode.left, treeNode.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

    public static String preOrder(TreeNode tree) {
        if (tree == null) return "";
        return tree.val
                + preOrder(tree.left)
                + preOrder(tree.right);
    }

    static List<String> series = new ArrayList<>();

    public static void inOrder(TreeNode tree) {
        if (tree == null) {
            series.add("N");
        } else {
            if (tree.left == null && tree.right == null)
                series.add("" + tree.val);
            else
                inOrder(tree.left);
            series.add("" + tree.val);
            inOrder(tree.right);
        }
    }

    public static String postOrder(TreeNode tree) {
        if (tree == null) return "";
        return postOrder(tree.left)
                + postOrder(tree.right)
                + tree.val;
    }
}
