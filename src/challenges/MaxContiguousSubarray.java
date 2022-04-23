package challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali Tofigh 4/20/2022 5:41 PM
 */

public class MaxContiguousSubarray {
    public static void main(String[] args) {
        System.out.println(findSubArrays(new int[]{5,2,8,3,10,12,20}, 5, 12));
    }

    public static int findSubArrays(int[] nums, int left, int right) {

        List<Integer> tmpArray = new ArrayList<>();

        for (int i : nums) {
            if (i > left - 1 && i < right + 1)
                tmpArray.add(i);
        }

        return (int) (Math.pow(2, tmpArray.size()) - 2);
    }
}
