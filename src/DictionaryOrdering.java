import java.util.*;

public class DictionaryOrdering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            String alphabet = scanner.next(); // New alphabet ordering
            int m = scanner.nextInt(); // Size of the set S
            scanner.nextLine(); // Consume the newline character

            String[] words = new String[m];
            for (int i = 0; i < m; i++) {
                words[i] = scanner.nextLine(); // Read the words
            }

            Arrays.sort(words, (a, b) -> compareWords(a, b, alphabet)); // Sort the words based on new alphabet

            for (String word : words) {
                System.out.println(word);
            }
        }
    }

    private static int compareWords(String a, String b, String alphabet) {
        int n = a.length();
        int m = b.length();
        int length = Math.min(n, m);

        for (int i = 0; i < length; i++) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);

            int indexA = alphabet.indexOf(charA);
            int indexB = alphabet.indexOf(charB);

            if (indexA != indexB) {
                return Integer.compare(indexA, indexB);
            }
        }

        return Integer.compare(n, m); // If both words have same prefix, shorter word comes first
    }
}
