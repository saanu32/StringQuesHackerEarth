public class PalindromeCost {

    public static int minPalindromeCost(String string, int aCost, int bCost) {
        int n = string.length();
        int left = 0;
        int right = n - 1;
        int cost = 0;

        while (left < right) {
            if (string.charAt(left) == string.charAt(right)) {
                if (string.charAt(left) == '/') {
                    // Both characters are '/', so choose the minimum cost replacement
                    cost += Math.min(aCost, bCost) * 2;
                }
            } else if (string.charAt(left) == '/') {
                // Replace '/' with the character at the right index
                if (string.charAt(right) == 'a') {
                    cost += aCost;
                } else {
                    cost += bCost;
                }
            } else if (string.charAt(right) == '/') {
                // Replace '/' with the character at the left index
                if (string.charAt(left) == 'a') {
                    cost += aCost;
                } else {
                    cost += bCost;
                }
            } else {
                // Both characters are not '/', and they are different, so palindrome is not possible
                return -1;
            }

            left++;
            right--;
        }

        return cost;
    }

    public static void main(String[] args) {
        String string = "baba//aaa/ab//";
        int aCost = 72;
        int bCost = 23;

        int minCost = minPalindromeCost(string, aCost, bCost);
        System.out.println(minCost);
    }
}

