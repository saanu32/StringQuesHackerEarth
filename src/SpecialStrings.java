import java.util.Scanner;

public class SpecialStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        int count = countSpecialSubstrings(S);
        System.out.println(count);
    }

    public static int countSpecialSubstrings(String S) {
        int count = 0;
        int n = S.length();

        // Count the substrings where all characters are the same
        for (int i = 0; i < n; i++) {
            count++;  // Single character substring
            int j = i + 1;
            while (j < n && S.charAt(j) == S.charAt(i)) {
                count++;
                j++;
            }
        }

        // Count the substrings with odd length and all characters same except the middle character
        for (int i = 1; i < n - 1; i++) {
            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && right < n && S.charAt(left) == S.charAt(right) && S.charAt(i) != S.charAt(left)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
//time complexity O(n^2)
//space complexity  O(1)