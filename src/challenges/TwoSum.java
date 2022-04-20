package challenges;

import java.util.Arrays;

/**
 * @author Ali Tofigh 4/4/2022 10:05 AM
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 25, 33, 12, 15, 2, 9}, 27);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        boolean f = true;
        for (int i = 0; (i < nums.length) && f; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j == i)
                    continue;
                if (nums[i] + nums[j] == target) {
                    f = false;
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }
        return indices;
    }
}
