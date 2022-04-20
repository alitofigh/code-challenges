package challenges.simple;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/**
 * @author Ali Tofigh 4/17/2022 6:10 PM
 */

public class ShowLikes {

    public static void main(String[] args) {
        //System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
        //System.out.println(maskify("254116"));
        //System.out.println(highAndLow("-1 -2 -3"));
        System.out.println(Arrays.toString(solve(new String[]{"abcdefghijklmnopqrstuvwxyza","ABCDEFGHIJKLMNOPQRSTUVWXYZ","xyzDEFghijabc"})));
    }

    public static String whoLikesIt(String... names) {
        if (names.length == 0)
            return "no one likes this";
        else if (names.length == 1)
            return names[0] + " likes this";
        else if (names.length == 2)
            return names[0] + " and " + names[1] + " like this";
        else if (names.length == 3)
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        else {
            String result = names[0] + ", " + names[1] + " and %s others like this";
            int num = -1;
            while (num < names.length)
                num++;
            return String.format(result, num);
        }
    }

    public static String maskify(String str) {
            /*if (str.length() < 5)
            return str;
        return "#".repeat(Math.max(0, str.length() - 4)) +
                str.substring(str.length() - 4);*/

        return str.replaceAll(".(?=.{4})", "#");
    }

    public static String highAndLow(String str) {
        /*String[] numbers = str.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String n : numbers) {
            int tmp = Integer.parseInt(n);
            if (tmp > max)
                max = tmp;
            if (tmp < min)
                min = tmp;
        }
        return max + " " + min;*/

        var stats = stream(str.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
    }

    public static int[] solve(String[] str) {
        /*String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabetC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] res = new int[str.length];
        int j = 0;
        for (String s : str) {
            int i = 0;
            for (int k = 0; k < s.length() && k < 26; k++) {
                if (s.charAt(k) == alphabet.charAt(k)
                        || s.charAt(k) == alphabetC.charAt(k))
                    i++;
            }
            res[j] = i;
            j++;
        }
        return res;*/
        return Stream.of(str).map(String::toLowerCase).mapToInt(ShowLikes::countLetters).toArray();
    }

    public static int countLetters(String str) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return IntStream.range(0, str.length()).filter(i -> alphabet.indexOf(str.charAt(i)) == i).toArray().length;
    }
}
