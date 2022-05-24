package challenges.codility.intview1;

import javax.management.relation.RelationException;
import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}, new int[]{4,1,3,2}));
    }

    public static boolean solution(int[] A, int[] B) {
        // write your code in Java SE 8

        if (A[0] == B[0]||A[1] == B[1]||A[2] == B[2]||A[3] == B[3])
            return false;

        int n = A.length;
        int start = A[0];

        //for (int i = 0; i < n; i++)


        Map<Integer, Integer> relations = new HashMap<>();
        for (int i = 0; i < n; i++) {
            relations.put(A[i],B[i]);
        }
        int next = start;
        int step = 0;
        while (step < n) {
            int m  = relations.get(next);
            step++;
            if (m != next) {
                next = m;
            } else
                break;
        }
        if (step == n)
            return true;
        else
            return false;

    }
}
