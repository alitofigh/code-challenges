package challenges;

/**
 * @author Ali Tofigh 3/15/2022 2:45 PM
 */

public class ValidPalindrome {
    public static void main(String[] args) {
        validatePalindrome();
    }

    private static void validatePalindrome() {
        //String data = "Ay ui1l/iu:yA";
        String data = "0p";
        char[] chars = data.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                res.append(c);
            }
        }
        String s = res.toString().toLowerCase();
        boolean f = true;
        char[] chars1 = s.toCharArray();
        for (int i = 0, j = chars1.length - 1; i <= j; i++, j--) {
            if (chars1[i] != chars1[j]) {
                f = false;
                break;
            }
        }
        System.out.println("result: " + f);
        System.out.println(res.toString());
    }
}
