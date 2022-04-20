package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ali Tofigh 4/17/2022 1:54 PM
 */

public class IntersectionTwoList {
    public static void main(String[] args) {

    }

    public static String intersection(String[] l1, String[] l2) {
        List<String> collect = new ArrayList<>();
        for (String s : l1) {
            if (Arrays.asList(l2).contains(s))
                collect.add(s);
        }

        if (collect.size() < 1)
            return "false";

        StringBuilder res = new StringBuilder();
        for (String num : collect)
            res.append(",").append(num);
        return res.substring(1);
    }
}
