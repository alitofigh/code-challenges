package challenges;

/**
 * @author Ali Tofigh 4/5/2022 5:50 PM
 */

// without using

public class DivideTwoIntegers {
    public static void main(String[] args) {
        long method1Start = System.currentTimeMillis();
        System.out.print(divide(Integer.MIN_VALUE, 2));
        long method1End = System.currentTimeMillis();
        System.out.println(", Duration: " + (method1End - method1Start));

        long method2Start = System.currentTimeMillis();
        System.out.print(divide2(Integer.MIN_VALUE, 2));
        long method2End = System.currentTimeMillis();
        System.out.println(", Duration: " + (method2End - method2Start));

        long method3Start = System.currentTimeMillis();
        System.out.print(divide3(Integer.MIN_VALUE, 2));
        long method3End = System.currentTimeMillis();
        System.out.println(", Duration: " + (method3End - method3Start));

        long method4Start = System.currentTimeMillis();
        System.out.print(new Solution().divide(Integer.MIN_VALUE, 2));
        long method4End = System.currentTimeMillis();
        System.out.println(", Duration: " + (method4End - method4Start));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (dividend == Integer.MAX_VALUE && divisor == -1)
            return Integer.MIN_VALUE;
        int i = 0;
        boolean dividendN = false;
        boolean divisorN = false;
        if (dividend < 0) {
            dividendN = true;
        }

        if (divisor < 0) {
            divisorN = true;
        }

        if (dividendN && divisorN)

            while (dividend <= divisor) {
                dividend -= divisor;
                i++;
            }
        if (!dividendN && !divisorN)
            while (dividend >= divisor) {
                dividend -= divisor;
                i++;
            }
        if (!dividendN && divisorN)
            while (dividend >= Math.abs(divisor)) {
                dividend += divisor;
                i++;
            }

        if (dividendN && !divisorN)
        while (dividend <= (divisor * -1)) {
            dividend += divisor;
            i++;
        }


        if ((!dividendN && divisorN) || (dividendN && !divisorN))
            return i * -1;
        else
            return i;
    }

    public static int divide2(int dividend, int divisor) {
        // If dividend is zero, return zero directly.
        if (dividend == 0) {
            return 0;
        }

        // To let our strategy to work, we should handle the case if divisor is INT_MIN.
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        // Use exclusve or to check the sign of answer.
        boolean is_pos = (dividend > 0) ^ (divisor < 0);
        int ans = 0;

        // Here is different from the description above.
        // In practice, we force our dividend to be negative.
        // Because the range of negative values (2^32) is larger than the range of positive values (2^32 - 1).
        // If we force dividend to be positive, there may be integer overflow.
        if (dividend > 0) {
            dividend = 0 - dividend;
        }

        // Divisor should be positive.
        // Because we will apply bitwise shift to it.
        // And we have handled the case when divisor is INT_MIN.
        if (divisor < 0) {
            divisor = 0 - divisor;
        }

        // To compare negative dividend and positive divisor, we need to add negative sign to divisor.
        while (dividend <= -divisor) {
            int tmp = divisor;
            int step = 1;

            // "tmp < 0x40000000" is a trick. 0x40000000 is 2 ^ 31.
            // If we don't limit the upper bound, tmp may keep shifting and lead an integer overflow.
            while (tmp < 0x40000000 && -tmp > dividend) {
                tmp <<= 1;
                step <<= 1;
            }

            // Here we find the largest divisor.
            if (-tmp < dividend) {
                tmp >>= 1;
                step >>= 1;
            }

            dividend += tmp;

            // Another trick is that using minus instead of using add.
            // The same reason as above: the range of negative values is larger than the range of positive values.
            ans -= step;
        }

        if (!is_pos) {
            return ans;
        } else {
            return ans == Integer.MIN_VALUE ? Integer.MAX_VALUE : -ans;
        }
    }

/*
    childhood method:
     3) 10 (2
         6
    _________
       3)4(
         3
    __________
       3)1(

      same here too
      first we will remove maximum 2 multiple of divisor
      example: 10 3
      3 6 12 24  ---doubling each time
      so we can subtract 6 from 10 so we remainded with 10-6=>4  add 2 to result
      3 6 ..
      so we can subtract 3 from 4 so remainded with 4-3=>1 add 1 to result

      2<<1 ==>4
      if we left shift 1 bit it indicates we are multiplying num by'2'
    */

    public static int divide3(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor > 0);

        long lDividend = Math.abs(dividend);
        long lDivisor = Math.abs(divisor);
        long result = 0;
        while ((lDividend - lDivisor) >= 0) {
            int cnt = 0;
            while (lDividend >= (lDivisor << cnt)) cnt++;
            result += (1L <<cnt-1);
            lDividend -= lDivisor<<(cnt-1);
        }
        if (result > Integer.MAX_VALUE) return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
        return (int) (sign?result:-result);
    }

    static class Solution {
        public int divide(int dividend, int divisor) {
            if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
            boolean sign = (dividend < 0) == (divisor < 0);
            dividend = dividend > 0? -dividend: dividend;
            divisor = divisor > 0? -divisor: divisor;
            int res = div(dividend, divisor);
            return sign? res: -res;
        }

        public int div(int dividend, int divisor){
            if(dividend > divisor) return 0;
            int curSum = divisor << 1, prevSum = divisor, q = 1;

            while(dividend <= curSum && curSum < prevSum){
                prevSum = curSum;
                curSum +=curSum;
                q += q;
            }
            return q + div(dividend - prevSum, divisor);
        }
    }
}
