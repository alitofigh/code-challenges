import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> response = generate(10);
        for (List<Integer> l : response) {
            for (Integer n : l) {
                System.out.print(n + ", ");
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 1 || numRows > 30)
            return null;
        List<List<Integer>> result;
        if (numRows == 1)
            result = new ArrayList<>(Arrays.asList(
                    new ArrayList<>() {{
                        add(1);
                    }}
            ));
        else
            result = new ArrayList<>(Arrays.asList(
                    new ArrayList<>() {{
                        add(1);
                    }},
                    new ArrayList<>() {{
                        add(1);
                        add(1);
                    }}
            ));
        int i = 2;
        while (i < numRows) {
            List<Integer> lastRow = result.get(result.size() - 1);
            List<Integer> newRows = new ArrayList<>();
            newRows.add(1);
            for (int j = 0; j < lastRow.size() - 1; j++) {
                newRows.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            //if (i )
            newRows.add(1);
            result.add(new ArrayList<>(newRows));
            i++;
        }
        return result;
    }
}
