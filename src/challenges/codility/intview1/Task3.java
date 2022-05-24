package challenges.codility.intview1;

import java.util.ArrayList;
import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        int[] sol = solution(new int[]{1,2,3,4}, 4, 6);

        for (int i : sol)
            System.out.print(i + ",");
    }

    public static int[] solution(int[] A, int F, int M) {
        // write your code in Java SE 8
        int numRoll = A.length + F;
        int sum = M * numRoll;
        int currentKnownSum = 0;
        for (int j : A) {
            currentKnownSum += j;
        }
        int lack = sum - currentKnownSum;
        if (lack < 1 || lack > F * 6)
            return new int[] {0};
        int[] missedRoll = new int[F];
        int i = 0;
        while (lack > 0) {
            if (missedRoll[i] < 6)
                missedRoll[i] += 1;
            lack--;
            i++;
            if (i >= F)
                i = 0;
        }
        return missedRoll;
    }
}
