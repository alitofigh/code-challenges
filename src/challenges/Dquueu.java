package challenges;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Dquueu {
    public static void findMax(int i, List<Integer> list, Deque<Integer> q , int arr[]){
        while(!q.isEmpty() && arr[i]>=arr[q.getLast()]){
            q.pollLast();
        }
        q.addLast(i);

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[n-k+1];
        List<Integer> list = new ArrayList<>();
        Deque<Integer> q
                = new LinkedList<Integer>();
        for(int i =0;i<k;i++)
        {
            findMax(i,list,q,nums);
        }


        for(int i = k;i<n;i++){
            list.add(nums[q.getFirst()]);
            if(q.getFirst()==i-k){
                q.pollFirst();
            }

            findMax(i,list,q,nums);

        }
        list.add(nums[q.getFirst()]);
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }

        return array;
    }
}
