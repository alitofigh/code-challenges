package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> parenthesis = generateParenthesis(4);
        System.out.println(Arrays.toString(parenthesis.toArray()));

    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = 1, close = 0;
        String p = "(";
        gp(p,open,close,n,ans);
        return ans;
    }


    static void gp(String p,int o,int c,int n,List<String> ans) {
        if(p.length() == 2*n) {
            ans.add(p);
            return;
        }
        if(o<n) gp(p+"(",o+1,c,n,ans);
        if(c<o) gp(p+")",o,c+1,n,ans);
    }
}
