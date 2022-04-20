package challenges;

import challenges.difination.TreeNode;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * @author Ali Tofigh 4/19/2022 2:23 PM
 */

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(10368));
        System.out.println("---------------------");
        System.out.println(solution2(10368));
    }

    public static int solution(int n) {
        String binary = Integer.toBinaryString(n);
        System.out.println(binary);
        List<Integer> maxGaps = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        int index = 0;
        char[] chars = binary.toCharArray();
        char c = chars[index];
        while (index < binary.lastIndexOf('1')) {
            while (c == '1') {
                c = chars[index];
                index++;
            }
            startIndex = index - 1;
            while (c == '0') {
                c = chars[index];
                index++;
            }
            endIndex = index - 1;
            maxGaps.add(endIndex - startIndex);
        }
        int maxGap = 0;
        for (int i : maxGaps)
            if (i > maxGap)
                maxGap = i;
        return maxGap;
    }

    public static int solution2(int input) {
        String s = Integer.toBinaryString(input);
        System.out.println(s);
        String temp;
        int length = 0;
        while (!s.isEmpty()) {
            if (!s.contains("01") || !s.contains("10")) break;
            temp = s.substring(s.indexOf("10") + 1, s.indexOf("01") + 1);
            if (temp.isEmpty()) break;
            length = Math.max(length, temp.length());
            s = s.substring(s.indexOf("01") + 1);
        }
        return length;
    }
}
