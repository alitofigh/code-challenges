package challenges;

import java.math.BigDecimal;

/**
 * @author Ali Tofigh 3/15/2022 2:39 PM
 */

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseDigits(2599941));
        System.out.println(reverseInteger(2599941));
    }

    private static int reverseDigits(int number) {
        int rev = 0;
        while (number != 0) {
            int r = number % 10;
            number /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && r > 7)
                    || rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && r < -8))
                return 0;
            rev = rev * 10 + r;
        }
        return rev;
    }

    //solution 2 (weaker)
    private static int reverseInteger(long num) {
        String number = BigDecimal.valueOf(num).toString();
        StringBuilder result = new StringBuilder();
        if (num < 0) {
            result.append("-");
            number = number.substring(1);
        }
        char[] chars = number.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }
        return Integer.parseInt(result.toString());
    }
}
