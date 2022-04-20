package challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali Tofigh 4/20/2022 10:42 AM
 */

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println("" + removeDuplicates(new int[]{1, 1, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int j = 100000000;
        for (int i : nums) {
            if (i == j) {
                continue;
            }
            result.add(i);
            j = i;
        }
        for (int i = 0; i < nums.length; i++)
            if (i > result.size() - 1)
                nums[i] = -1;
            else
                nums[i] = result.get(i);
        return result.size();
    }
}
