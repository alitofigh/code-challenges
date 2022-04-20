package challenges;

import java.util.*;

/**
 * @author Ali Tofigh 4/4/2022 12:13 PM
 */

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString());
        List<String> strings = letterCombinations("23");
        strings.stream().forEach(s -> System.out.print(s + ", "));




    }

    public static List<String> letterCombinations(String digits) {
        Map<String, String> maps = new HashMap<>();
        maps.put("2", "abc");
        maps.put("3", "def");
        maps.put("4", "ghi");
        maps.put("5", "jkl");
        maps.put("6", "mno");
        maps.put("7", "pqrs");
        maps.put("8", "tuv");
        maps.put("9", "wxyz");

        List<String> res = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            String key = digits.substring(i, i + 1);
            if (res.size() > 0) {
                for (int r = 0; r < res.size(); r++) {
                    for (int c = 0; c < maps.get(key).length(); c++) {
                      temp.add(res.get(r) + maps.get(key).charAt(c));
                    }
                }
                res = temp;
            } else {
                for (int c = 0; c < maps.get(key).length(); c++) {
                    res.add(maps.get(key).substring(c, c + 1));
                }
            }
        }

        return res;
    }
}
