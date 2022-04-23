package challenges;

import jdk.jfr.consumer.RecordedThread;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println("result: " + isMatch("aabbbfg", "aab*.g"));
    }

    public static boolean isMatch(String s, String p) {

        int i;
        for (i = 0; (i < p.length() - 1) && s.length() > 0; i++) {
            char c1 = p.charAt(i);
            char c2 = p.charAt(i + 1);
            if ('*' == c2) {
                i++;
                int j = 0;
                while (s.charAt(j) == c1) {
                    j++;
                }
                s = s.substring(j);
            } else if ('.' == c1) {
                s = s.substring(1);
            } else {
                if (s.substring(0, 1).toCharArray()[0] == c1)
                    s = s.substring(1);
                else
                    return false;
            }
        }
        return i >= p.length() && s.isEmpty();
    }
}
