package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Ali Tofigh 4/13/2022 11:55 AM
 */

public class Parantez {

    private static final List<Character> open_sign =
            new ArrayList<>(Arrays.asList('[', '{', '('));
    private static final List<Character> close_sign =
            new ArrayList<>(Arrays.asList(']', '}', ')'));
    private static final List<String> validCouple =
            new ArrayList<>(Arrays.asList("()", "{}", "[]"));

    public static void main(String[] args) {

        String expression = "(coder)(byte))";
        System.out.println(BracketMatcher(new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}));
       // System.out.println(validateExpression(expression));
    }

    public static boolean validateExpression(String expression) {
        // definitions
        List<Character> open_sign = new ArrayList<>(Arrays.asList('[', '{', '('));
        List<Character> close_sign = new ArrayList<>(Arrays.asList(']', '}', ')'));
        List<String> validCouple = new ArrayList<>(Arrays.asList("()", "{}", "[]"));
        Stack<Character> stack = new Stack<>();

        if (expression == null || expression.isEmpty())
            return true;

        for (Character c : expression.toCharArray()) {
            if (open_sign.contains(c))
                stack.push(c);
            else if (close_sign.contains(c)) {
                if (stack.empty())
                    return false;
                Character pop = stack.pop();
                if (!validCouple.contains(pop.toString() + c.toString()))
                    return false;
            } else
                return false;
        }
        return stack.empty();
    }

    /*public boolean ss(String ex) {
        if (ex == null || ex.isEmpty())
            return true;
        String sign = ex.substring(0 , 1);
        ex = ex.substring(1);
    }*/


    public static String BracketMatcher(String[] strArr) {
        String[] exp1 = strArr[0].split(",");
        String[] exp2 = strArr[1].split(",");

        List<String> collect = new ArrayList<>();
        for (String s : exp1) {
            if (Arrays.asList(exp2).contains(s))
                collect.add(s);
        }

        if (collect.size() < 1)
            return "false";

        StringBuilder res = new StringBuilder();
        for(String num : collect)
            res.append(",").append(num);
        return res.substring(1);
    }

}
